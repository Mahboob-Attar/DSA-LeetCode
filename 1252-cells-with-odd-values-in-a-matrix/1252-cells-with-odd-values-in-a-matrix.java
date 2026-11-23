class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        // Perform all operations
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];

            // Increment entire row
            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }

            // Increment entire column
            for (int i = 0; i < m; i++) {
                matrix[i][col]++;
            }
        }

        // Count odd values
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
