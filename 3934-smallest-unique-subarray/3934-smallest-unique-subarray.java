class Solution {
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
        }

        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(nums, mid, pow1, pow2)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int len,
                          long[] pow1, long[] pow2) {

        int n = nums.length;

        HashMap<Long, Integer> map = new HashMap<>();

        long h1 = 0;
        long h2 = 0;

        // Calculate first window hash
        for (int i = 0; i < len; i++) {
            h1 = (h1 * BASE1 + nums[i]) % MOD1;
            h2 = (h2 * BASE2 + nums[i]) % MOD2;
        }

        long key = (h1 << 32) | h2;
        map.put(key, 1);

        // Slide the window
        for (int i = len; i < n; i++) {

            h1 = (h1 - (nums[i - len] * pow1[len - 1]) % MOD1
                    + MOD1) % MOD1;

            h1 = (h1 * BASE1 + nums[i]) % MOD1;

            h2 = (h2 - (nums[i - len] * pow2[len - 1]) % MOD2
                    + MOD2) % MOD2;

            h2 = (h2 * BASE2 + nums[i]) % MOD2;

            key = (h1 << 32) | h2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}