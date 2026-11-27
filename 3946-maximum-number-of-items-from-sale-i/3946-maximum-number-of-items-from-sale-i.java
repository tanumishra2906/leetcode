class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];
        int minPrice = Integer.MAX_VALUE;

        // Har item ka free count calculate karna
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }
        int[] dp = new int[budget + 1];
        // -1 matlab itna exact amount spend karna
        // abhi possible nahi hai
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;
        // 0/1 Knapsack
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int gain = 1 + free[i];
            // Reverse loop taki free benefit
            // same item se baar baar na mile
            for (int b = budget; b >= price; b--) {
                if (dp[b - price] != -1) {
                    dp[b] = Math.max(dp[b],
                                    dp[b - price] + gain);
                }
            }
        }

        int ans =0;
        // Remaining budget se cheapest items kharidna
        for (int b=0; b <= budget; b++) {
            if (dp[b]!= -1) {
                int remaining = budget - b;
                int extra = remaining / minPrice;
                ans = Math.max(ans, dp[b] + extra);
            }
        }
        return ans;
    }
}