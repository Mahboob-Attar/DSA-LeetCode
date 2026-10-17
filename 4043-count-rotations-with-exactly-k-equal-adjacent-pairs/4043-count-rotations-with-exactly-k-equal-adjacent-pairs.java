class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int score = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                score++;
            }
        }

        int ans = (score == k) ? 1 : 0;

        for (int i = n; i < 2 * n - 1; i++) {
            if (s.charAt(i % n) == s.charAt((i - 1) % n)) {
                score++;
            }

            if (s.charAt(i % n) == s.charAt((i + 1) % n)) {
                score--;
            }

            if (score == k) {
                ans++;
            }
        }

        return ans;
    }
}