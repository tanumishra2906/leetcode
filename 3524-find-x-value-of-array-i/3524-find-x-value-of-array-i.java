class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;
            long[] next = new long[k];

            next[mod] = 1;

            for (int i = 0; i < k; i++) {
                int newMod = (int) (1L * i * mod % k);
                next[newMod] += dp[i];
            }

            for (int i = 0; i < k; i++) {
                ans[i] += next[i];
            }

            dp = next;
        }

        return ans;
    }
}