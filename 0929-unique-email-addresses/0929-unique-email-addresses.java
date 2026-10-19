class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            StringBuilder normalized = new StringBuilder();
            boolean afterPlus = false;
            boolean domain = false;

            for (char c : email.toCharArray()) {
                if (c == '@') {
                    domain = true;
                    normalized.append(c);
                    continue;
                }

                if (domain) {
                    normalized.append(c);
                } else if (c == '+') {
                    afterPlus = true;
                } else if (c == '.') {
                    if (!afterPlus) continue;
                } else if (!afterPlus) {
                    normalized.append(c);
                }
            }

            unique.add(normalized.toString());
        }

        return unique.size();
    }
}
