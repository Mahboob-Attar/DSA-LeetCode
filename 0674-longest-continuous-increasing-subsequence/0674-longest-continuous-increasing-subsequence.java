class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int current = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            max = Math.max(max, current);
        }

        return max;
    }
}