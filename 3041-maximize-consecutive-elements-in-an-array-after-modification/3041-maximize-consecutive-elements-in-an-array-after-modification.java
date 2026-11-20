class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int keep = dp.getOrDefault(num - 1, 0);
            int increase = dp.getOrDefault(num, 0);

            dp.put(num, Math.max(
                dp.getOrDefault(num, 0), keep + 1
            ));

            dp.put(num + 1, Math.max(
                dp.getOrDefault(num + 1, 0), increase + 1
            ));

            ans = Math.max(ans,
                Math.max(dp.get(num), dp.get(num + 1)));
        }

        return ans;
    }
}
