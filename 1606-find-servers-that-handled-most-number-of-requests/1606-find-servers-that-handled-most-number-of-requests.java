class Solution {
    public List<Integer> busiestServers(int k,int[] arrival,int[] load) {
        //Available servers ko sorted order mein rakhenge
        TreeSet<Integer> available=new TreeSet<>();
        //Busy servers: [freeTime,serverId]
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] count=new int[k];
        //Shuru mein saare servers available hain
        for(int i=0;i<k;i++) available.add(i);

        for(int i=0;i<arrival.length;i++){

            //Jo servers free ho chuke hain unhe available mein daalo
            while(!busy.isEmpty()&&busy.peek()[0]<=arrival[i]){
                available.add(busy.poll()[1]);
            }

            //Agar koi server available nahi hai toh request drop
            if(available.isEmpty()) continue;

            //i%k se preferred server find karo
            int server=i%k;
            Integer next=available.ceiling(server);

            //Aage available nahi mila toh starting se search karo
            if(next==null) next=available.first();

            //Server ko available list se hatao
            available.remove(next);

            //Server ka request count badhao
            count[next]++;

            //Server ka free hone ka time aur ID store karo
            busy.offer(new int[]{arrival[i]+load[i],next});
        }
        //Maximum requests find karo
        int max=0;
        for(int c:count) max=Math.max(max,c);
        //Jis server ne maximum requests handle ki hain use return karo
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(count[i]==max) ans.add(i);
        }
        return ans;
    }
}


/* Is question mein humein k servers diye gaye hain aur multiple requests alag-alag time par aati hain. Har request ko pehle `i % k` wale server ko dena hai. Agar woh busy hai, toh next available server ko denge (zarurat padne par starting se check karenge). Agar saare servers busy hain, toh request drop ho jayegi. Humein count karna hai ki har server ne kitni requests handle ki aur jis server ne sabse zyada requests handle ki hain, un sabhi server IDs ko return karna hai. */