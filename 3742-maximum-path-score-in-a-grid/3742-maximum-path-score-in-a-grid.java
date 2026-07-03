class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][k + 1];

        int ans = solve(0, 0, grid, k, dp);

        return ans < 0 ? -1 : ans;
    }

    public int solve(int i, int j, int[][] grid, int k, Integer[][][] dp) {

        if (i >= grid.length || j >= grid[0].length)
            return -1000000;

        if(dp[i][j][k] != null) return dp[i][j][k];

        int cost = grid[i][j] == 0 ? 0 : 1;

        if (k < cost)
            return -1000000;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];

        int down = grid[i][j] + solve(i + 1, j, grid, k - cost, dp);

        int right = grid[i][j] + solve(i, j + 1, grid, k - cost, dp);

        return dp[i][j][k] = Math.max(right, down);

    }
}