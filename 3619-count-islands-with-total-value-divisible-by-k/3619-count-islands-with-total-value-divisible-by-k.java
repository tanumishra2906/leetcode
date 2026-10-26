class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // Poori grid ko traverse karenge
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Positive value mili toh naya island explore karenge
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j, rows, cols);

                    // Check karo ki island ka sum k se divisible hai
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j,
                     int rows, int cols) {

        // Grid ke bahar jaane par 0 return karenge
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0L;
        }

        // Water ya visited cell ko ignore karenge
        if (grid[i][j] == 0) {
            return 0L;
        }

        // Current cell ki value long mein save karenge
        long sum = grid[i][j];

        // Visited cell ko 0 mark karenge
        grid[i][j] = 0;

        // Chaaro directions ke connected cells ka sum add karenge
        sum += dfs(grid, i - 1, j, rows, cols);
        sum += dfs(grid, i + 1, j, rows, cols);
        sum += dfs(grid, i, j - 1, rows, cols);
        sum += dfs(grid, i, j + 1, rows, cols);

        return sum;
    }
}

// Question: Har connected island ka total sum nikalo.
// Agar sum k se divisible ho, toh island ko count karo.