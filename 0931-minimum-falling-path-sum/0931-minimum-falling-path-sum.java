//with help
class Solution{
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        //base case
        for(int j = 0 ; j < m ; j++){
            dp[0][j] = matrix[0][j];
        }
        //fill up dp
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int up = dp[i - 1][j];
                int left;
                if(j > 0){
                    left = dp[i - 1][j - 1];
                }else{
                    left = Integer.MAX_VALUE;
                }
                int right;
                if(j < m - 1){
                    right = dp[i - 1][j + 1];
                }else{
                    right = Integer.MAX_VALUE;
                }
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < m ; j++){
            if(dp[n - 1][j] < min){
                min = dp[n - 1][j];
            }
        }
        return min;
    }
}


//still memoization didn't work here
// class Solution{
//     public int minFallingPathSum(int[][] matrix){
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[][] dp = new int[n + 1][m + 1];
//         for(int[] rows : dp){
//             Arrays.fill(rows, -1);
//         }
//         int min = Integer.MAX_VALUE;
//         for(int j = 0 ; j < m ; j++){
//             min = Math.min(min, solve(0, j, n, m, matrix, dp));
//         }
//         return min;
//     }
//     public int solve(int i, int j, int n, int m, int[][] matrix, int[][] dp){
//         if(j < 0 || j >= m) return Integer.MAX_VALUE;
//         if(i == n - 1) return dp[i][j] = matrix[i][j];
//         if(dp[i][j] != -1) return dp[i][j];

//         int down = solve(i + 1, j, n, m, matrix, dp);
//         int right = solve(i + 1, j + 1, n, m, matrix, dp);
//         int left = solve(i + 1, j - 1, n, m, matrix, dp);

//         return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(right, left));
//     }
// }



// very wrong approach
// //recursive
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         return solve(0, 0, 0, n, m, matrix);
//     }
//     public int solve(int i, int j, int sum, int n, int m, int[][] matrix){
//         if(i == n - 1) return matrix[i][j];
//         int min = Integer.MAX_VALUE;
//         for(int ind = j ; ind < m ; ind++){
//             if(j < 1){
//                 int down = sum + solve(i + 1, j, sum, n, m, matrix);
//                 int right = sum + solve(i + 1, j + 1, sum, n, m, matrix);
//                 min = Math.min(down, right);
//             }else if(j == m - 1){
//                 int down = sum + solve(i + 1, j, sum, n, m, matrix);
//                 int left = sum + solve(i + 1, j - 1, sum, n, m, matrix);
//                 min = Math.min(down, left);
//             }else{
//                 int down = sum + solve(i + 1, j, sum, n, m, matrix);
//                 int right = sum + solve(i + 1, j + 1, sum, n, m, matrix);
//                 int left = sum + solve(i + 1, j - 1, sum, n, m, matrix);
//                 min = Math.min(down, Math.min(right, left));
//             }
//         }
//         return min;
//     }
// }