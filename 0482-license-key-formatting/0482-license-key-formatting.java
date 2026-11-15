class Solution {
    public String licenseKeyFormatting(String s, int k) {

        s = s.replace("-", "").toUpperCase();

        StringBuilder ans = new StringBuilder();

        int first = s.length() % k;

        if (first > 0) {
            ans.append(s.substring(0, first));
        }

        for (int i = first; i < s.length(); i += k) {

            if (ans.length() > 0) {
                ans.append("-");
            }

            ans.append(s.substring(i, i + k));
        }

        return ans.toString();
    }
}
