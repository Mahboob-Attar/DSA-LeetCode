class Solution {

    static class Upgrade {
        long cost;
        long count;

        Upgrade(long cost, long count) {
            this.cost = cost;
            this.count = count;
        }
    }

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        long minPrice = Long.MAX_VALUE;
        int[] freq = new int[n + 1];

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
            freq[item[0]]++;
        }

        // Calculate how many free items each type can generate.
        int[] gain = new int[n + 1];

        for (int f = 1; f <= n; f++) {
            int count = 0;

            for (int j = f; j <= n; j += f) {
                count += freq[j];
            }

            gain[f] = count - 1;
        }

        // Each upgrade gives one additional free item.
        List<Upgrade> upgrades = new ArrayList<>();

        for (int[] item : items) {
            int factor = item[0];
            long extraCost = item[1] - minPrice;

            if (gain[factor] > 0 && extraCost <= minPrice) {
                upgrades.add(new Upgrade(extraCost, gain[factor]));
            }
        }

        upgrades.sort((a, b) -> Long.compare(a.cost, b.cost));

        long k = 0;
        long spentExtra = 0;

        long answer = budget / minPrice;
        long maxBase = budget / minPrice;

        for (Upgrade u : upgrades) {

            // Maximum upgrades possible while keeping
            // enough budget for their baseline purchases.
            long remaining = budget - spentExtra - minPrice * k;

            if (remaining < 0) {
                break;
            }

            long canTake = remaining / (minPrice + u.cost);

            canTake = Math.min(canTake, u.count);
            canTake = Math.min(canTake, maxBase - k);

            if (canTake <= 0) {
                continue;
            }

            k += canTake;
            spentExtra += canTake * u.cost;

            long remainingBase =
                (budget - spentExtra) / minPrice;

            answer = Math.max(answer, remainingBase + k);
        }

        return (int) answer;
    }
}
