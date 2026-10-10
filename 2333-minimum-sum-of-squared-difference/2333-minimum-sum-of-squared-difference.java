
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (total <= k) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long ans = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, low);
            ans += (long) reduced * reduced;
            used += d - reduced;
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= low && low > 0) {
                ans -= (long) low * low;
                ans += (long) (low - 1) * (low - 1);
                remaining--;
            }
        }

        return ans;
    }
}