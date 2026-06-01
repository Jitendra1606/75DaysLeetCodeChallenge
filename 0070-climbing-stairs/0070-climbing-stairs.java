//using bottom up (tabulation)
class Solution{
    public int climbStairs(int n){
        if(n <= 3) return n;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//t.c = O(n) 
//s.c = O(n)

//using bottom up with space optimization
// class Solution{
//     public int climbStairs(int n){
//         if(n <= 3) return n;

//         int prev2 = 1;
//         int prev1 = 2;

//         for(int i = 3 ; i <= n ; i++){
//             int cur = prev1 + prev2;

//             prev2 = prev1;
//             prev1 = cur;
//         }
//         return prev1;
//     }
// }
//t.c = O(n)
//s.c = O(1)


//using top down DP(memoization)
// class Solution{
//     public int climbStairs(int n){
//         int[] dp = new int[n + 1];
//         return solve(n, dp);
//     }

//     public int solve(int n, int[] dp){
//         if(n <= 3) return dp[n] = n;

//         if(dp[n] != 0) return dp[n];

//         return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
//     }
// }
//t.c = O(n) 
//s.c = O(n) (dp + recursion stack)


//using recursion
// class Solution{
//     public int climbStairs(int n){
//         if(n <= 3) return n;

//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }
//t.c = O(2^n)
//s.c = O(n) (recursion stack)