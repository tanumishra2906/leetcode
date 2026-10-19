class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //1st step should be sorting giving array
        Arrays.sort(nums);
        //make new list to store indices
        List<Integer> ans= new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
            }
        }

        return ans;


        
    }
}