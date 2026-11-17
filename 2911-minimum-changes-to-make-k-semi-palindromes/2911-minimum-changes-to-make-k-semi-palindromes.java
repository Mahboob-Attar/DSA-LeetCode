class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        // Precompute semi-palindrome conversion cost
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int best = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int groups = len / d;
                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        for (int t = 0; t < groups / 2; t++) {
                            int left = i + r + t * d;
                            int right = i + r + (groups - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[i][i + len - 1] = best;
            }
        }

        // DP: first i characters divided into parts
        int INF = 1_000_000_000;
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int parts = 1; parts <= k; parts++) {

                // Every substring must have length >= 2
                for (int j = 2 * (parts - 1); j <= i - 2; j++) {
                    if (dp[j][parts - 1] == INF) continue;

                    dp[i][parts] = Math.min(
                        dp[i][parts],
                        dp[j][parts - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
