
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Duplicate first element skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1; //this no is constant

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    // Duplicate left values skip karo
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Duplicate right values skip karo
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return ans;
    }
}

/* 3Sum mein hum pehle array ko sort karte hain, phir `i` pointer se ek number fix karte hain aur `left = i + 1` aur `right = n - 1` rakhte hain. Ab in teen numbers ka sum check karte hain. Agar sum `0` hai, toh triplet answer mein add karte hain aur `left++` aur `right--` karte hain. Agar sum `0` se chhota hai, toh `left++` karte hain kyunki humein bada number chahiye; agar sum `0` se bada hai, toh `right--` karte hain kyunki humein chhota number chahiye. Duplicate checks ka purpose same triplet ko baar-baar answer mein aane se rokna hai. Isliye `i` ke liye check karte hain ki current number previous number ke equal toh nahi; agar equal hai, toh `continue` karke skip kar dete hain. Similarly, jab ek valid triplet milta hai, toh `left` aur `right` ke duplicate numbers ko `while` loops se skip karte hain, taaki same values dobara use karke duplicate triplet na bane. Is tarah humein saare unique triplets mil jaate hain jinka sum `0` hota hai.
 */