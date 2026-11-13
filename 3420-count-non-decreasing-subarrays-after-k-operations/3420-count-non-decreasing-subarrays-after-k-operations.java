class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<long[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int count = 1;

            // Merge smaller blocks into the current block
            while (!dq.isEmpty() && dq.peekLast()[0] < nums[i]) {

                long[] curr = dq.pollLast();

                long value = curr[0];
                long cnt = curr[1];

                count += cnt;

                cost += (nums[i] - value) * cnt;
            }

            dq.offerLast(new long[]{nums[i], count});

            // Shrink window while cost exceeds k
            while (cost > k) {

                long[] first = dq.pollFirst();

                long value = first[0];
                long cnt = first[1];

                cost -= value - nums[j];
                j--;

                if (cnt > 1) {
                    dq.offerFirst(new long[]{value, cnt - 1});
                }
            }

            // Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
