class Solution{
    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length(), m = text2.length();

        Integer[][] dp = new Integer[n + 1][m + 1];

        for(int i = 0 ; i < n + 1 ; i++) dp[i][0] = 0;
        for(int j = 0 ; j < m + 1 ; j++) dp[0][j] = 0;

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < m + 1 ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public int solve(int i, int j, String s, String t, Integer[][] dp){
        if(i <= 0 || j <= 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1)){
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, t, dp);
        }
        return dp[i][j] = Math.max(solve(i - 1, j, s, t, dp), solve(i, j - 1, s, t, dp));
    }
}


//top down dp
// class Solution{
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for(int i = 0 ; i < m + 1 ; i++){
//             for(int j = 0 ; j < n + 1 ; j++){
//                 if(i == 0 || j == 0) dp[i][j] = 0;
//             }
//         }
//         for(int i = 1 ; i < m + 1 ; i++){
//             for(int j = 1 ; j < n + 1 ; j++){
//                 if(text1.charAt(i - 1) == text2.charAt(j - 1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }else{
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int[][] dp = new int[n + 1][m + 1];
//         for(int[] row : dp) Arrays.fill(row, -1);

//         return solve(text1, text2, 0, 0, n, m, dp);
//     }
//     public int solve(String x, String y, int i, int j, int n, int m, int[][] dp){
//         if(i == n || j == m) return 0;

//         if(dp[i][j] != -1) return dp[i][j];

//         if(x.charAt(i) == y.charAt(j)) return dp[i][j] = 1 + solve(x, y, i + 1, j + 1, n, m, dp);
//         else return dp[i][j] = Math.max(solve(x, y, i + 1, j, n, m, dp), solve(x, y, i, j + 1, n, m, dp));
//     }
// }



//recusrive code and it got us TLE at 17/47 testcases
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         return solve(text1, text2, n, m);
//     }
//     public int solve(String x, String y, int n, int m){
//         if(n == 0 || m == 0) return 0;
//         if(x.charAt(n - 1) == y.charAt(m - 1)) return 1 + solve(x, y, n - 1, m - 1);
//         else return Math.max(solve(x, y, n, m - 1), solve(x, y, n - 1, m));
//     }
// }

