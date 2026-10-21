class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Child pointer
        int j = 0; // Cookie pointer

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // Satisfy this child
            }

            j++; // Use this cookie or discard it
        }

        return i;
    }
}
