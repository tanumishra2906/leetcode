class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        //1st find the max element
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        
        }

        //now count total moves it took to reach that max element
        int total=0;
        for(int i=0;i<nums.length;i++){
            int moves=max-nums[i];
            total=total+moves;
        
        }

        return total;
        
    }
}