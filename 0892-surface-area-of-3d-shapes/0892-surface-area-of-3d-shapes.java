class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int h = grid[i][j];

                if (h == 0) continue;

                // Top and bottom surfaces
                area += 2;

                // Front surface
                area += (i == 0) ? h : Math.max(0, h - grid[i - 1][j]);

                // Back surface
                area += (i == n - 1) ? h : Math.max(0, h - grid[i + 1][j]);

                // Left surface
                area += (j == 0) ? h : Math.max(0, h - grid[i][j - 1]);

                // Right surface
                area += (j == n - 1) ? h : Math.max(0, h - grid[i][j + 1]);
            }
        }

        return area;
    }
}
