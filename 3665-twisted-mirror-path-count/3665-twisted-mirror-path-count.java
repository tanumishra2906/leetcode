
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    right[i][j] = i * n + j;
                    down[i][j] = i * n + j;
                } else {
                    right[i][j] =
                        (i + 1 < m) ? down[i + 1][j] : -1;
                    down[i][j] =
                        (j + 1 < n) ? right[i][j + 1] : -1;
                }
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                if (j + 1 < n) {
                    int dest = right[i][j + 1];

                    if (dest != -1) {
                        int x = dest / n;
                        int y = dest % n;

                        dp[x][y] = (int)(
                            (dp[x][y] + (long) dp[i][j]) % MOD
                        );
                    }
                }
                if (i + 1 < m) {
                    int dest = down[i + 1][j];

                    if (dest != -1) {
                        int x = dest / n;
                        int y = dest % n;

                        dp[x][y] = (int)(
                            (dp[x][y] + (long) dp[i][j]) % MOD
                        );
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

