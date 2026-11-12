class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;
        int ans=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inc++;
                dec=1; //inc subarray mila toh dec ko 1 set i.e reset to initial
            }
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            else {
                inc = 1;
                dec = 1;
            }
            ans=Math.max(ans,Math.max(inc,dec)) ;//jo ans aaya and prev existing ans se max find

        }
        return ans;
        
    }
}