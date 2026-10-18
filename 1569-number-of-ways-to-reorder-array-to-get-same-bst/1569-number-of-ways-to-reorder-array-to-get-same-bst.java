
class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations: nCr
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;

        // Empty or single-node BST has only one arrangement
        if (n <= 2) {
            return 1;
        }

        int root = nums[0];

        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();

        // Divide elements according to BST rules
        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }
        // Convert lists into arrays
        int[] leftArr = left.stream().mapToInt(Integer::intValue).toArray();
        int[] rightArr = right.stream().mapToInt(Integer::intValue).toArray();

        int L = leftArr.length;
        int R = rightArr.length;

        // Arrange left and right elements while preserving
        // their internal order
        long ways = comb[L + R][L];

        ways = (ways * solve(leftArr)) % MOD;
        ways = (ways * solve(rightArr)) % MOD;

        return ways;
    }
}
