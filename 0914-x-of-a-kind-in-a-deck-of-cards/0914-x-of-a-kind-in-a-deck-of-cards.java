class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10001];

        // Count frequency of each card
        for (int card : deck) {
            freq[card]++;
        }

        int gcd = 0;

        // Find GCD of all frequencies
        for (int count : freq) {
            if (count > 0) {
                gcd = findGCD(gcd, count);
            }
        }

        return gcd >= 2;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
