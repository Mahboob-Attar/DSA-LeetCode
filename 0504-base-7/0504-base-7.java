class Solution {
    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        boolean negative = num < 0;

        long n = Math.abs((long) num);

        StringBuilder sb = new StringBuilder();

        while (n > 0) {

            long remainder = n % 7;

            sb.append(remainder);

            n = n / 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}