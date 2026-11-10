class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] required = new int[26];

        // Count required characters
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                required[Character.toLowerCase(ch) - 'a']++;
            }
        }

        String answer = "";

        for (String word : words) {

            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] < required[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid && (answer.isEmpty() ||
                          word.length() < answer.length())) {
                answer = word;
            }
        }

        return answer;
    }
}
