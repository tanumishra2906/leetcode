class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        // Har index par check karo ki element apni correct position par hai ya nahi
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                // Jo elements misplaced hain, unke bits common hone chahiye
                // Isliye un sabka AND nikalenge
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        // Agar array pehle se sorted hai, toh answer 0 hoga
        return k == -1 ? 0 : k;
    }
}

// Question: Maximum k find karna hai jiske liye
// nums[i] AND nums[j] == k wale swaps se array sort ho sake.