class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < n; i++) {
            if (rowShift[i] == 0)
                continue;
            row(grid, i, rowShift[i]);
        }

        for (int i = 0; i < n; i++) {
            if (colShift[i] == 0)
                continue;
            col(grid, i, colShift[i]);
        }

        return grid;
    }

    public void row(int[][] rows, int i, int k) {
        k = k % rows.length;

        while (k-- > 0) {
            int temp = rows[i][0];

            for (int x = 0; x < rows.length - 1; x++) {
                rows[i][x] = rows[i][x + 1];
            }

            rows[i][rows[i].length - 1] = temp;
        }
    }

    public void col(int[][] rows, int i, int k) {
        k = k % rows.length;

        while (k-- > 0) {
            int temp = rows[0][i];

            for (int x = 0; x < rows.length - 1; x++) {
                rows[x][i] = rows[x + 1][i];
            }

            rows[rows.length - 1][i] = temp;
        }
    }
}