class Solution {

    int l, m;
    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };
    boolean[][] visited;
    Boolean[][][] dp;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = grid.get(i).get(j);
            }
        }

        l = mat.length;
        m = mat[0].length;

        visited = new boolean[l][m];
        dp = new Boolean[l][m][health + 1];

        return dfs(0, 0, mat, health - mat[0][0]);

    }

    public boolean dfs(int row, int col, int[][] mat, int health) {

        if (health < 1)
            return false;

        if (row == l - 1 && col == m - 1) {
            return health > 0;
        }

        if (dp[row][col][health] != null)
            return dp[row][col][health];

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if (newr >= 0 && newc >= 0 && newr < l && newc < m && mat[newr][newc] == 0 && !visited[newr][newc]
                    && health > 0) {
                if (dfs(newr, newc, mat, health))
                    return dp[newr][newc][health] = true;
            } else if (newr >= 0 && newc >= 0 && newr < l && newc < m && mat[newr][newc] == 1 && !visited[newr][newc]
                    && health > 0) {
                if (dfs(newr, newc, mat, health - 1))
                    return dp[newr][newc][health] = true;
            }
        }
        visited[row][col] = false;
        return dp[row][col][health] = false;
    }
}