class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != '-') {
                sb.append(Character.toUpperCase(ch));

                // Add hyphen after every k characters
                if (sb.length() % (k + 1) == k) {
                    sb.append('-');
                }
            }
        }

        // Remove trailing hyphen if present
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
