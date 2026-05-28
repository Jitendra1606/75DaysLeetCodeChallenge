class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0 ; i < n + 1 ; i++) dp[i][0] = 1;
// Empty string t = "" can always be formed from any prefix of s in exactly ONE way:delete everything

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < m + 1 ; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}


// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();

//         int[][] dp = new int[n + 1][m + 1];
//         for(int[] row : dp) Arrays.fill(row, -1);

//         return solve(0, 0, n, m, s, t, dp);
//     }

//     public int solve(int i, int j, int n, int m, String s, String t, int[][] dp) {
//         if (j >= m)
//             return 1; //agar t ko pass kr gya to hme ek answer mil gya mtlb

//         if (i >= n)
//             return 0; //agar s ko pointer cross kr de rha h

//         if(dp[i][j] != - 1) return dp[i][j];

//         if (s.charAt(i) == t.charAt(j)) {
//             return dp[i][j] = solve(i + 1, j + 1, n, m, s, t, dp) + solve(i + 1, j, n, m, s, t, dp);
//         }
//         return dp[i][j] = solve(i + 1, j, n, m, s, t, dp);
//     }
// }


// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length(), m = t.length();

//         return solve(0, 0, n, m, s, t);
//     }

//     public int solve(int i, int j, int n, int m, String s, String t) {
//         if (j >= m)
//             return 1; //agar t ko pass kr gya to hme ek answer mil gya mtlb

//         if (i >= n)
//             return 0; //agar s ko pointer cross kr de rha h

//         if (s.charAt(i) == t.charAt(j)) {
//             return solve(i + 1, j + 1, n, m, s, t) + solve(i + 1, j, n, m, s, t);
//         }
//         return solve(i + 1, j, n, m, s, t);
//     }
// }