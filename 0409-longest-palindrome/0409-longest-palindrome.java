class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        // Count character frequencies
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : freq) {

            // Use pairs of characters
            length += (count / 2) * 2;

            // Check if any character has an odd frequency
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        // One odd-frequency character can be placed in the center
        if (hasOdd) {
            length++;
        }

        return length;
    }
}