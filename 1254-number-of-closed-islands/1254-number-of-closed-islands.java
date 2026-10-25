class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // Poori grid ko row aur column wise traverse karenge
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Agar land (0) mila, toh DFS se island check karenge
                if (grid[i][j] == 0) {

                    // DFS true dega toh island closed hai, count badha do
                    if (dfs(grid, i, j, rows, cols)) {
                        count++;
                    }
                }
            }
        }

        // Total closed islands return karenge
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j,
                        int rows, int cols) {

        // Agar grid ki boundary cross ho gayi,
        // toh island closed nahi hai
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        // Agar water (1) mila, toh is direction mein land nahi hai
        if (grid[i][j] == 1) {
            return true;
        }

        // Visited land ko 1 mark kar do taaki dobara visit na ho
        grid[i][j] = 1;

        // Chaar directions mein DFS chala kar island explore karenge
        boolean up = dfs(grid, i - 1, j, rows, cols);
        boolean down = dfs(grid, i + 1, j, rows, cols);
        boolean left = dfs(grid, i, j - 1, rows, cols);
        boolean right = dfs(grid, i, j + 1, rows, cols);

        // Island tabhi closed hoga jab chaaro directions true hon
        return up && down && left && right;
    }
}

// Question: 0 land aur 1 water hai.
// DFS se har connected island check karte hain.
// Jo island boundary ko touch nahi karta, use count karte hain.