//using top down dp
class Solution{
    public int fib(int n){
        int[] dp = new int[n + 1];
        if(n == 0 || n == 1) return n;
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

//using recursion + memoization
// class Solution{
//     int[] dp = new int[31];
//     public int fib(int n){
//         Arrays.fill(dp, -1);
//         return solve(n);
//     }
//     public int solve(int n){
//         if(n <= 1){
//             dp[n] = n;
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         dp[n] = solve(n - 1) + solve(n - 2);
//         return dp[n];
//     }
// }




//using recursion
// class Solution {
//     public int fib(int n) {
//         if(n <= 1){
//             return n;
//         }
//         return fib(n - 1) + fib(n - 2);
//     }
// }

//using for loop
// class Solution{
//     public int fib(int n){
//         if(n <= 1) return n;
//         int a = 0, b = 1;
//         for(int i = 2 ; i <= n ; i++){
//             int temp = a + b;
//             a = b;
//             b = temp;
//         } 
//         return b;
//     }
// }