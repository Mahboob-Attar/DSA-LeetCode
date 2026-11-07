import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        // Available servers: (weight, index)
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: (freeAt, weight, index)
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Long.compare(a[0], b[0]);

                if (cmp != 0) return cmp;

                cmp = Long.compare(a[1], b[1]);

                if (cmp != 0) return cmp;

                return Long.compare(a[2], b[2]);
            }
        );

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Initially, all servers are available.
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            // Current time cannot go backwards.
            time = Math.max(time, i);

            // Release all servers that have finished.
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= time) {

                long[] server = busy.poll();

                available.offer(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            // No available server: wait.
            if (available.isEmpty()) {

                time = busy.peek()[0];

                // Release every server finishing at this time.
                while (!busy.isEmpty() &&
                       busy.peek()[0] <= time) {

                    long[] server = busy.poll();

                    available.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            // Select the best available server.
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Assign the task and calculate finish time.
            long finishTime = time + tasks[i];

            busy.offer(new long[]{
                finishTime,
                weight,
                index
            });
        }

        return ans;
    }
}