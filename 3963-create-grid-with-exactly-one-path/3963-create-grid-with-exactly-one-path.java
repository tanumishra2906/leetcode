class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        // Puri grid ko '#' se fill karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }
        // First row ko free banao
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        // Last column ko free banao
        for (int i = 1; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        // char[][] ko String[] mein convert karo
        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }
        return ans;
    }
}