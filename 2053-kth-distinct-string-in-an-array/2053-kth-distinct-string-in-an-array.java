class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> seen = new HashSet<>();

        for (String s : arr) {
            seen.add(s);
        }

        for (String s : arr) {
            int count = 0;

            for (String t : arr) {
                if (s.equals(t)) {
                    count++;
                }
            }

            if (count == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }
}
