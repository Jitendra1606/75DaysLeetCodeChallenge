// bottom up dp
class Solution{
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //first row
        for(int j = 1; j < n ; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //first column
        for(int i = 1 ; i < m ; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                int down = dp[i - 1][j];
                int right = dp[i][j - 1];
                dp[i][j] = grid[i][j] + Math.min(down, right);
            }
        }
        return dp[m - 1][n - 1];
    }
}

// memoized 
// class Solution{
//     public int minPathSum(int[][] grid){
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] dp = new int[m][n];
//         for(int[] rows : dp){
//             Arrays.fill(rows, -1);
//         }
//         return solve(0, 0, m, n, grid, dp);
//     }
//     public int solve(int i, int j, int m, int n, int[][] grid, int[][] dp){
//         if((i == m - 1) && (j == n - 1)) return grid[i][j];
//         if((i >= m) || (j >= n)) return Integer.MAX_VALUE;
//         if(dp[i][j] != -1) return dp[i][j];
//         int down = solve(i + 1, j, m, n, grid, dp);
//         int right = solve(i, j + 1, m, n, grid, dp);
//         return dp[i][j] = grid[i][j] + Math.min(down, right);
//     }
// }

// tle at 25 / 66 testcases
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         return solve(0, 0, m, n, grid);
//     }
//     public int solve(int i, int j, int m, int n, int[][] grid){
//         if((i >= m) || (j >= n)) return Integer.MAX_VALUE;
//         if((i == m - 1) && (j == n - 1)) return grid[i][j];
//         int down = solve(i + 1, j, m, n, grid);
//         int right = solve(i, j + 1, m, n, grid);
//         return grid[i][j] + Math.min(down, right);
//     }
// }