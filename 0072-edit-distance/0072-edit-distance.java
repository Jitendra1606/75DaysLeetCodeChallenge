class Solution{
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(word1, word2, n, m, 0, 0, dp);
    }
    public int solve(String s1, String s2, int n, int m, int i, int j, int[][] dp){
        if(i == n) return m - j;
        else if(j == m) return n - i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1, s2, n, m, i + 1, j + 1, dp);

        int insert = 1 + solve(s1, s2, n, m, i, j + 1, dp);
        int delete = 1 + solve(s1, s2, n, m, i + 1, j, dp);
        int replace = 1 + solve(s1, s2, n, m, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}


// class Solution{
//     public int minDistance(String word1, String word2){
//         int n = word1.length(), m = word2.length();

//         return solve(0, 0, n, m, word1, word2);
//     }

//     public int solve(int i, int j, int n, int m, String s1, String s2){
//         if(i == n) return m - j;
//         else if(j == m) return n - i;

//         if(s1.charAt(i) == s2.charAt(j)) return solve(i + 1, j + 1, n, m, s1, s2);

//         int insert = 1 + solve(i, j + 1, n, m, s1, s2);
//         int delete = 1 + solve(i + 1, j, n, m, s1, s2);
//         int replace = 1 + solve(i + 1, j + 1, n, m, s1, s2);

//         return Math.min(insert, Math.min(delete, replace));
//     }
// }


// 5 - bottom up
// class Solution{
//     public int minDistance(String word1, String word2){
//         int n = word1.length(), m = word2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for(int i = 0 ; i < n + 1 ; i++){
//             for(int j = 0 ; j < m + 1 ; j++){
//                 if(i == 0 || j == 0) dp[i][j] = i + j;
//                 else if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
//                 else dp[i][j] = 1 + Math.min(dp[i][j -1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
//             }
//         }
//         return dp[n][m];
//     }
// }

// 4 - memoized version of below one
// class Solution{
//     public int minDistance(String word1, String word2){
//         int n = word1.length();
//         int m = word2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for(int[] rows : dp) Arrays.fill(rows, -1);
//         return solve(word1, word2, n, m, dp);
//     }
//     public int solve(String s1, String s2, int n, int m, int[][] dp){
//         if(n == 0) return m;
//         else if(m == 0) return n;
//         if (dp[n][m] != -1) return dp[n][m];
//         if(s1.charAt(n - 1) == s2.charAt(m - 1)) return dp[n][m] = solve(s1, s2, n - 1, m - 1, dp);
//         int insert = 1 + solve(s1, s2, n, m - 1, dp);
//         int delete = 1 + solve(s1, s2, n - 1, m, dp);
//         int replace = 1 + solve(s1, s2, n - 1, m - 1, dp);
//         return dp[n][m] = Math.min(insert, Math.min(delete, replace));
//     }
// }

// 3 - now we will go from right to left m to 0 and n to 0
// class Solution{
//     public int minDistance(String word1, String word2){
//         int n = word1.length();
//         int m = word2.length();
//         return solve(word1, word2, n, m);
//     }
//     public int solve(String s1, String s2, int n, int m){
//         if(n == 0){
//             return m;
//         }else if(m == 0){
//             return n;
//         }
//         if(s1.charAt(n - 1) == s2.charAt(m - 1)) return solve(s1, s2, n - 1, m - 1);
//         int insert = 1 + solve(s1, s2, n, m - 1);
//         int delete = 1 + solve(s1, s2, n - 1, m);
//         int replace = 1 + solve(s1, s2, n - 1, m - 1);
//         return Math.min(insert, Math.min(delete, replace));
//     }
// }

// 2 - memoized
// class Solution{
//     public int minDistance(String word1, String word2){
//         int n = word1.length();
//         int m = word2.length();
//         int[][] dp = new int[n][m];
//         for(int[] rows : dp){
//             Arrays.fill(rows, -1);
//         }
//         return solve(word1, word2, n, m, 0, 0, dp);
//     }
//     public int solve(String s1, String s2, int n, int m, int i, int j, int[][] dp){
//         if(i == n) return m - j;
//         else if(j == m) return n - i;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1, s2, n, m, i + 1, j + 1, dp);

//         int insert = 1 + solve(s1, s2, n, m, i, j + 1, dp);
//         int delete = 1 + solve(s1, s2, n, m, i + 1, j, dp);
//         int replace = 1 + solve(s1, s2, n, m, i + 1, j + 1, dp);

//         return dp[i][j] = Math.min(insert, Math.min(delete, replace));
//     }
// }

//1 - pure recursive function (best for understanding) tle at 26/1149 testcase
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         return solve(word1, word2, n, m, 0, 0); 
//     }
//     public int solve(String s1, String s2, int n, int m, int i, int j){
//         if(i == s1.length()) return m - j; //means we need to insert some elements
//         else if(j == s2.length()) return n - i; //means we have found all the characters but some characters remained in s1. so we need to delete some char of s1
//         if(s1.charAt(i) == s2.charAt(j)) return solve(s1, s2, n, m, i + 1, j + 1); //means we just have to increase both pointers bcz both char are same
//         //now the three operations
//         int insert = 1 + solve(s1, s2, n, m, i, j + 1);
//         int delete = 1 + solve(s1, s2, n, m, i + 1, j);
//         int replace = 1 + solve(s1, s2, n, m, i + 1, j + 1);

//         return Math.min(insert, Math.min(delete, replace));
//     }
// }