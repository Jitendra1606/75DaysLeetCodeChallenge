//memoization it still giving tle
class Solution{
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1) return triangle.get(0).get(0);
        Integer[][] dp = new Integer[n][n];
        // for(int[] rows : dp){
        //     Arrays.fill(rows, -1);
        // }
        return solve(0, 0, n, triangle, dp);
    }
    public int solve(int i, int j, int n, List<List<Integer>> result, Integer[][] dp){
        if(i == n - 1) return dp[i][j] = result.get(i).get(j);
        if(dp[i][j] != null) return dp[i][j];
        int down = solve(i + 1, j, n, result, dp);
        int downRight = solve(i + 1, j + 1, n, result, dp);
        return dp[i][j] = result.get(i).get(j) + Math.min(down, downRight); 
    }
}

// recursive approach tle at 27/46
// class Solution{
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         return solve(0, 0, n, triangle);
//     }
//     public int solve(int i, int j, int n, List<List<Integer>> result){
//         if(i == n - 1) return result.get(i).get(j);
//         int down = solve(i + 1, j, n, result);
//         int downRight = solve(i + 1, j + 1, n, result);
//         return result.get(i).get(j) + Math.min(down, downRight);
//     }
// }




// class Solution {
//     public int solve(int i, int j, List<List<Integer>> triangle, int[][] dp) {
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         if (i == 0) {
//             return dp[i][j] = triangle.get(i).get(j);
//         }
//         int up = Integer.MAX_VALUE;
//         int diag = Integer.MAX_VALUE;
//         if (j <= i - 1)
//             up = solve(i - 1, j, triangle, dp);
//         if (j > 0)
//             diag = solve(i - 1, j - 1, triangle, dp);
//         return dp[i][j] = triangle.get(i).get(j) + Math.min(up, diag);
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
//         for (int[] row : dp)
//             Arrays.fill(row, -1);
//         int ans = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             ans = Math.min(ans, solve(n - 1, j, triangle, dp));
//         }
//         return ans;
//     }
// }
