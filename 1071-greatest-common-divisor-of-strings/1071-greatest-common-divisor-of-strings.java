class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Check whether both strings have a common repeating pattern
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Calculate GCD of string lengths
        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
