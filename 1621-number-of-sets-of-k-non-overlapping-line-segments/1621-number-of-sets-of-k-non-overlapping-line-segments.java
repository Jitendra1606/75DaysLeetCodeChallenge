class Solution {
    Integer[][] dp;
    static final int MOD = (int)(1e9 + 7);
    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;

        dp = new Integer[N + 1][R + 1];
        return solve(N, R) % MOD;
    }

    public int solve(int n, int r){
        if(r < 0 || r > n) return 0;
        
        if(r == 0 || r == n) return 1;

        if(dp[n][r] != null) return dp[n][r];

        int left = solve(n - 1, r - 1);
        int right = solve(n - 1, r);

        return dp[n][r] = (left + right) % MOD;
        //ncr = (n-1)c(r-1) + (n-1)c(r)
    }
}



// class Solution {
//     static final int MOD = (int)(1e9 + 7);
//     public int numberOfSets(int n, int k) {
//         return solve(n + k - 1, 2 * k) % MOD;
//     }

//     public int solve(int n, int r){
//         if(r == 0) return 1;

//         if(r == n) return 1;

//         return (solve(n - 1, r - 1) + solve(n - 1, r)) % MOD;
//         //ncr = (n-1)c(r-1) + (n-1)c(r)
//     }
// }

// k segments
//     ↓
// each has 2 endpoints
//     ↓
// 2k endpoint occurrences
//     ↓
// segments may touch
//     ↓
// need k-1 extra positions
//     ↓
// n + k - 1 positions
//     ↓
// choose 2k of them
//     ↓
//              ┌───────────────┐
//              │ C(n+k-1, 2k) │
//              └───────────────┘