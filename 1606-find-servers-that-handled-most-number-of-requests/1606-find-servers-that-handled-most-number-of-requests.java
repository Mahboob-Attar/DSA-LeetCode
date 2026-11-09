class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // Available server indices
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Busy servers: {finishTime, serverIndex}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[k];
        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {

            // Release servers whose tasks are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                long[] server = busy.poll();
                available.add((int) server[1]);
            }

            // No available server: drop this request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server using circular order
            int preferred = i % k;

            // Find first available server >= preferred
            Integer server = available.ceiling(preferred);

            // Wrap around if no such server exists
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;

            maxRequests = Math.max(maxRequests, count[server]);

            // Calculate when server becomes free
            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        // Collect servers with maximum requests
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}