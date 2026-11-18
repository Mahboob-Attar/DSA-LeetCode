class Solution {
    public int countSegments(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // A new segment starts when:
            // current character is not a space
            // previous character is a space or doesn't exist
            if (s.charAt(i) != ' ' &&
                (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }
}
