class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                dp[i + 1][j + 1] = grid[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
                if(dp[i + 1][j + 1] <= k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}