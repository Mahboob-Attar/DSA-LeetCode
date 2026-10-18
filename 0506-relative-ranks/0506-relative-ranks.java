
import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) ->
            Integer.compare(score[b], score[a])
        );

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            int rank = i + 1;
            int originalIndex = idx[i];

            if (rank == 1) ans[originalIndex] = "Gold Medal";
            else if (rank == 2) ans[originalIndex] = "Silver Medal";
            else if (rank == 3) ans[originalIndex] = "Bronze Medal";
            else ans[originalIndex] = String.valueOf(rank);
        }

        return ans;
    }
}
