class Solution {
    final static int MOD = (int)(1e9 + 7);
    Integer[][][] dp;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m][2];

        return solve(0, 0, 0, n, m, grid);
    }

    //here d is for direction means if we are going to counter mirror so from which dir are we coming here
    public int solve(int i, int j, int d, int n, int m, int[][] grid){
        if(i == n - 1 && j == m - 1) return 1;

        if(i >= n || j >= m) return 0;

        if(dp[i][j][d] != null) return dp[i][j][d];

        if(grid[i][j] == 1){
            if(d == 0){                      //d = 0: Entered from the left (moving right).
                return dp[i][j][d] = solve(i + 1, j, 1, n, m, grid);
            } 
            else{                            //d = 1: Entered from above (moving down).
                return dp[i][j][d] = solve(i, j + 1, 0, n, m, grid);
            } 
        }

        return dp[i][j][d] = (solve(i + 1, j, 1, n, m, grid) + solve(i, j + 1, 0, n, m, grid)) % MOD;
    }
}