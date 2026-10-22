class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] freq = new int[1001];
        int n = nums.length;

        for (int[] arr : nums) {
            for (int num : arr) {
                freq[num]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == n) {
                result.add(i);
            }
        }

        return result;
    }
}
