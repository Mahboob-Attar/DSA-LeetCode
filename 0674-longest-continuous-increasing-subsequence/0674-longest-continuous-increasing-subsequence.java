class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            int length = 1;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[j - 1]) {
                    length++;
                } else {
                    break;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}