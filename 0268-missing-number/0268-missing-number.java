class Solution {
    public int missingNumber(int[] nums) {

        int n=nums.length;
        int actualsum=0;

        int expectedsum = (n*(n+1))/2;
        for(int i =0;i<nums.length;i++){
            actualsum = actualsum + nums[i];
        }


        return expectedsum - actualsum;
        
    }
}