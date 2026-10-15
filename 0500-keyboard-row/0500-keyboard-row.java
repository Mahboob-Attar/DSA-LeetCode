class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();
            String row;

            if (row1.indexOf(w.charAt(0)) != -1) {
                row = row1;
            } else if (row2.indexOf(w.charAt(0)) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (int i = 0; i < w.length(); i++) {
                if (row.indexOf(w.charAt(i)) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}