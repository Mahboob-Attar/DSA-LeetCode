class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < 0 && k > 0) {
                num = -num;
                k--;
            }

            sum += num;
            minAbs = Math.min(minAbs, num);
        }

        if (k % 2 == 1) {
            sum -= 2 * minAbs;
        }

        return sum;
    }
}