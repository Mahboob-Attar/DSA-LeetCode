class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int[] count = new int[1501];

        for (int[] item : items) {
            count[item[0]]++;
        }

        int[] free = new int[1501];

        for (int i = 1; i <= 1500; i++) {
            for (int j = i; j <= 1500; j += i) {
                free[i] += count[j];
            }

            free[i]--; // Exclude the current item itself
        }

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            int gain = 1 + free[factor];

            // First purchase
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b],
                        dp[b - price] + gain);
            }

            // Additional purchases
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b],
                        dp[b - price] + 1);
            }
        }

        return dp[budget];
    }
}
