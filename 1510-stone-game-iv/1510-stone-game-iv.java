class Solution{
    public boolean winnerSquareGame(int n){
        Boolean[] dp = new Boolean[n + 1];
        return solve(n, dp);
    }

    public boolean solve(int n, Boolean[] dp){
        if(n == 0) return false;

        if(dp[n] != null) return dp[n];

        for(int k = 1 ; k * k <= n ; k++){
            if(solve(n - k * k, dp) == false) return dp[n] = true; //mtlb bob haar liya
        }
        return dp[n] = false;
    }
}



// class Solution {
//     public boolean winnerSquareGame(int n) {
//         Boolean[] dp = new Boolean[n + 1];
//         return solve(n, dp); //alice ke liye call h ye, if it's true, alice wins else not
//     }

//     public boolean solve(int n, Boolean[] dp) {
//         if (n == 0)
//             return false; //qk jiske liye bhi call thi vo ab aage nhi ja skta

//         if (dp[n] != null)
//             return dp[n];

//         for (int k = 1; k * k <= n; k++) {
//             if (solve(n - k * k, dp) == false) //bob ke liye h ye, false-> alice wins
          
//                 return dp[n] = true; //alice wins the game
//         }
//         return dp[n] = false;
//     }
// }