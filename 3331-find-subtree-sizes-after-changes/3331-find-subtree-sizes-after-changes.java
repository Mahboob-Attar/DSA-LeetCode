class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] lastSeen = new int[26];
        int[] prevSeen = new int[n];

        Arrays.fill(lastSeen, -1);

        // Iterative DFS on original tree
        int[] stack = new int[2 * n + 5];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];

            if (event >= 0) {
                int node = event;
                int ch = s.charAt(node) - 'a';

                prevSeen[node] = lastSeen[ch];

                if (lastSeen[ch] != -1) {
                    newParent[node] = lastSeen[ch];
                }

                lastSeen[ch] = node;

                // Exit event
                stack[top++] = ~node;

                for (int i = adj[node].size() - 1; i >= 0; i--) {
                    stack[top++] = adj[node].get(i);
                }

            } else {
                int node = ~event;
                int ch = s.charAt(node) - 'a';

                lastSeen[ch] = prevSeen[node];
            }
        }

        // Build modified tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        // Get traversal order
        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];
            order[count++] = node;

            for (int child : tree[node]) {
                stack[top++] = child;
            }
        }

        // Calculate subtree sizes bottom-up
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (int i = count - 1; i > 0; i--) {
            int node = order[i];
            size[newParent[node]] += size[node];
        }

        return size;
    }
}
