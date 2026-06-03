class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, s, p, dp);
    }

    public boolean solve(int i, int j, String s, String t, int[][] dp){
        
        if(i < 0 && j < 0) return true;//if both strings get exhausteed
        if(i >= 0 && j < 0) return false;//if 1st string get exhausted
        if(i < 0 && j >= 0){ //if 2 string get exhauted but not 1 so
        // we can have possible ans if all char in 1st string are *            
            for(int k = 0 ; k <= j ; k++){
                if(t.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1; 

        if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '?'){
            boolean ans = solve(i - 1, j - 1, s, t, dp);

            dp[i][j] = ans ? 1 : 0;

            return ans;
        }
        if(t.charAt(j) == '*'){
            boolean ans = solve(i, j - 1, s, t, dp) || solve(i - 1, j, s, t, dp);

            dp[i][j] = ans ? 1 : 0;

            return ans;
        }
        dp[i][j] = 0;

        return false;
    }
}




//recursive(tle)
// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();

//         return solve(n - 1, m - 1, s, p);
//     }

//     public boolean solve(int i, int j, String s, String t){
        
//         if(i < 0 && j < 0) return true;//if both strings get exhausteed
//         if(i >= 0 && j < 0) return false;//if 1st string get exhausted
//         if(i < 0 && j >= 0){ //if 2 string get exhauted but not 1 so
//         // we can have possible ans if all char in 1st string are *            
//             for(int k = 0 ; k <= j ; k++){
//                 if(t.charAt(k) != '*') return false;
//             }
//             return true;
//         }

//         if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '?'){
//             return solve(i - 1, j - 1, s, t);
//         }
//         if(t.charAt(j) == '*'){
//             return solve(i, j - 1, s, t) || solve(i - 1, j, s, t);
//         }
//         return false;
//     }
// }