class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;

        // Option 1: Buy everything separately
        long option1 = (long) need1 * c1 + (long) need2 * c2;

        // Option 2: Buy common items using costBoth
        long common = Math.min(need1, need2);

        long option2 = common * cb
                     + (need1 - common) * c1
                     + (need2 - common) * c2;

        // Option 3: Buy costBoth for the maximum requirement
        long option3 = (long) Math.max(need1, need2) * cb;

        return Math.min(option1, Math.min(option2, option3));
    }
}