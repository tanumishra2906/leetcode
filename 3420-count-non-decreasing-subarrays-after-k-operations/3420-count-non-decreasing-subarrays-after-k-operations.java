
class Solution{
    public long countNonDecreasingSubarrays(int[] nums,int k){
        int n=nums.length;
        long ans=0,ops=0;
        int right=n-1;
        Deque<long[]> dq=new ArrayDeque<>();

        for(int left=n-1;left>=0;left--){
            long val=nums[left],cnt=1;
            // Jo aage ke elements chhote hain, unhe val tak badhana padega
            while(!dq.isEmpty() && dq.peekFirst()[0]<=val){
                long[] curr=dq.pollFirst();
                // In elements ko val banane ka total cost
                ops+=(val-curr[0])*curr[1];
                cnt+=curr[1];
            }
            // Updated value aur uske elements ki count store karo
            dq.addFirst(new long[]{val,cnt});
            // Agar operations k se zyada hain toh right se elements hatao
            while(ops>k){
                long[] curr=dq.pollLast();
                // Last element ko remove karne ka cost minus karo
                ops-=curr[0]-nums[right];
                curr[1]--;
                // Agar block mein aur elements bache hain toh wapas add karo
                if(curr[1]>0)dq.addLast(curr);
                right--;
            }
            // Current left se right tak ke saare subarrays valid hain
            ans+=right-left+1;
        }
        return ans;
    }
}
