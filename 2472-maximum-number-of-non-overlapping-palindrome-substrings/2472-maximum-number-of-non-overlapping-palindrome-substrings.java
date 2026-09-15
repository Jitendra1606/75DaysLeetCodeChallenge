//to optimize code furhter, we only need to optimize the palindrome function, if we can precompute it then it will reuce complexity much more

class Solution{
    Integer[] dp;
    boolean[][] pal;
    
    public int maxPalindromes(String s, int k){
        int n = s.length();

        dp = new Integer[n + 1];
        pal = new boolean[n][n];

        //precomputing palindromes
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = i ; j < n ; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || pal[i + 1][j - 1])){
                    pal[i][j] = true;
                }
            }
        }

        return solve(0, s, k);
    }

    public int solve(int i, String s, int k){
        if(i >= s.length()) return 0;

        if(dp[i] != null) return dp[i];

        int ans = solve(i + 1, s, k);

        for(int j = i + k - 1 ; j < s.length() ; j++){
            if(pal[i][j]){
                ans = Math.max(ans, 1 + solve(j + 1, s, k));
            }
        }

        return dp[i] = ans;
    }
}





//tle at 55 / 56
// class Solution {
//     Integer[] dp;
//     public int maxPalindromes(String s, int k) {
//         dp = new Integer[s.length() + 1];
//         return solve(0, s, k);
//     }

//     public int solve(int i, String s, int k) {

//         if(i >= s.length()) return 0;

//         if(dp[i] != null) return dp[i];

//         int ans = solve(i + 1, s, k); //skip it

//         for(int j = i + k - 1 ; j < s.length() ; j++){
//             if(isPalindrome(s, i, j)){
//                 ans = Math.max(ans, 1 + solve(j + 1, s, k));
//             }
//         }
//         return dp[i] = ans;
//     }

//     public boolean isPalindrome(String s, int i, int j) {
//         while (i < j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }