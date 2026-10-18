class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        Integer[] indices = new Integer[n];

        // Store original indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by score in descending order
        Arrays.sort(indices, (a, b) ->
            Integer.compare(score[b], score[a])
        );

        String[] answer = new String[n];

        // Assign ranks
        for (int i = 0; i < n; i++) {
            int originalIndex = indices[i];

            if (i == 0) {
                answer[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                answer[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                answer[originalIndex] = "Bronze Medal";
            } else {
                answer[originalIndex] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}
