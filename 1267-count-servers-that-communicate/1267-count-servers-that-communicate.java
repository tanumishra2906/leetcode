class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[] rowCount=new int[m]; // Har row me kitne servers hain
        int[] colCount=new int[n]; // Har column me kitne servers hain

        // 1st traversal: Har row aur column me servers count karo
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rowCount[i]++; // Current row ka server count badhao
                    colCount[j]++; // Current column ka server count badhao
                }
            }
        }
        int ans=0; // Communicate karne wale servers ka total count
        // 2nd traversal: Check karo kaunsa server communicate kar sakta hai
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){ // Sirf server wali cell check karenge
                    // Agar row ya column me 1 se zyada server hain
                    // Toh current server kisi dusre server se communicate kar sakta hai
                    if(rowCount[i]>1 || colCount[j]>1){
                        ans++; // Communicating server ko count karo
                    }
                }
            }
        }
        return ans; // Total communicating servers return karo
    }
}