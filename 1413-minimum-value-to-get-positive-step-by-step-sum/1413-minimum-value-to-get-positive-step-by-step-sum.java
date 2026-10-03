class Solution {
    public int minStartValue(int[] nums) {

        for (int start = 1; ; start++) {

            int sum = start;
            boolean valid = true;

            for (int num : nums) {
                sum += num;

                if (sum < 1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return start;
            }
        }
    }
}