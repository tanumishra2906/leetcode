class Solution {

    long mod1 = 1000000007L;
    long mod2 = 1000000009L;
    long base = 100003;

    public int smallestUniqueSubarray(int[] nums) {
        int low = 1, high = nums.length;
        // Binary search on subarray length
        while (low < high) {
            int mid = low + (high - low) / 2;
            // Unique mila toh chhoti length check karo
            if (check(nums, mid)) {
                high = mid;
            }
            // Nahi mila toh length badhao
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean check(int[] nums, int len) {
        HashMap<Long, Integer> map = new HashMap<>();
        long h1 = 0, h2 = 0;
        long p1 = 1, p2 = 1;
        // Pehle subarray ka hash banana
        for (int i = 0; i < len; i++) {
            h1 = (h1 * base + nums[i]) % mod1;
            h2 = (h2 * base + nums[i]) % mod2;
            p1 = (p1 * base) % mod1;
            p2 = (p2 * base) % mod2;
        }
        map.put((h1 << 32) | h2, 1);
        // Sliding window
        for (int i = len; i < nums.length; i++) {
            // Purana element hatao aur naya add karo
            h1 = (h1 * base + nums[i]
                - nums[i - len] * p1 % mod1+ mod1) % mod1;
            h2 = (h2 * base + nums[i]- nums[i - len] * p2 % mod2
                + mod2) % mod2;
            long key = (h1 << 32) | h2;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // Koi subarray sirf ek baar aaya hai?
        for (int freq : map.values()) {
            if (freq == 1)
                return true;
        }
        return false;
    }
}