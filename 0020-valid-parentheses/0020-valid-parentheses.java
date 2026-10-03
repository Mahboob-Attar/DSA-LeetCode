class Solution {
    public boolean isValid(String s) {

        String previous;

        do {
            previous = s;

            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");

        } while (!s.equals(previous));

        return s.isEmpty();
    }
}