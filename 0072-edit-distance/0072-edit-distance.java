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

// pure recursive function (bezt for understanding) tle at 26/1149 testcase
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