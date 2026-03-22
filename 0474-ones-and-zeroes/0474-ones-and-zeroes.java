//memoized
class Solution{
    public int findMaxForm(String[] strs, int m, int n){
//precomputing the counts of 0 and 1, so that we can know directly how many 1 & 0 are present in string otherwise we need to count them for every string everytime
        int[][] count = new int[strs.length][2];
        for(int i = 0 ; i < strs.length ; i++){
            int zero = 0, one = 0;
            for(int j = 0 ; j < strs[i].length() ; j++){
                char ch = strs[i].charAt(j);
                if(ch == '0') zero++;
                else one++;
            }
            count[i][0] = zero;
            count[i][1] = one;
        }
        //3d array bcz there are 3 variables on which our function depends
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for(int i = 0 ; i < strs.length ; i++){
            for(int j = 0 ; j <= m ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(count, m, n, 0, dp);
    }
    public int solve(int[][] count, int m, int n, int i, int[][][] dp){
        if(((m == 0) && (n == 0)) || (i >= count.length)) return 0;
        if(dp[i][m][n] != -1) return dp[i][m][n];
        int take = 0;
        if(count[i][0] <= m && count[i][1] <= n){
            take = 1 + solve(count, m - count[i][0], n - count[i][1], i + 1, dp);
        } 
        int not_take = solve(count, m, n, i + 1, dp);
        return dp[i][m][n] = Math.max(take, not_take);
    }
}

//recursive
// class Solution {
//     public int findMaxForm(String[] strs, int m, int n) {
//         //precomputing the counts of zeros and ones
//         int[][] count = new int[strs.length][2];
//         for(int i = 0 ; i < strs.length ; i++){
//             int zero = 0, one = 0;
//             for(int j = 0 ; j < strs[i].length() ; j++){
//                 char ch = strs[i].charAt(j);
//                 if(ch == '0') zero++;
//                 else one++;
//             }
//             count[i][0] = zero; //first index is for zero and other for one
//             count[i][1] = one;
//         }
//         return solve(count, m, n, 0);
//     }
//     public int solve(int[][] count, int m, int n, int i){
//         if(i >= count.length || ((m == 0) && (n == 0))) return 0;
//         int take = 0;
//         //also need to check if no. of zeros or ones are even sufficient for inclusion or not
//         if(count[i][0] <= m && count[i][1] <= n){
//             take = 1 + solve(count, m - count[i][0], n - count[i][1], i + 1);
//         }
//         int not_take = solve(count, m, n, i + 1);
//         return Math.max(take, not_take);
//     }
// }