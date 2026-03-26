//bottom up
class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int ind = n - 1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                for(int cap = 1 ; cap <= 2 ; cap++){
                    if(buy == 0){
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], -prices[ind] + dp[ind + 1][1][cap]);
                    }else{
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap], prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}

//memoized
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n][2][3];
//         for(int[][] mat : dp){
//             for(int[] rows : mat){
//                 Arrays.fill(rows, -1);
//             }
//         }
//         return solve(0, 1, 2, n, prices, dp);
//     }
//     public int solve(int ind, int buy, int capacity, int n, int[] prices, int[][][] dp){
//         if(ind == n) return 0;
//         if(capacity == 0) return 0;
//         if(dp[ind][buy][capacity] != -1) return dp[ind][buy][capacity];
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, capacity, n, prices, dp), 0 + solve(ind + 1, 1, capacity, n, prices, dp));
//         }else{
//             profit = Math.max(prices[ind] + solve(ind + 1, 1, capacity - 1, n, prices, dp), 0 + solve(ind + 1, 0, capacity, n, prices, dp));
//         }
//         dp[ind][buy][capacity] = profit;
//         return profit;
//     }
// }


// recursive
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         return solve(0, 1, 2, n, prices);
//     }
//     public int solve(int ind, int buy, int capacity, int n, int[] prices){
//         if(ind == n) return 0;
//         if(capacity == 0) return 0;
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, capacity, n, prices), 0 + solve(ind + 1, 1, capacity, n, prices));
//         }else{
//             profit = Math.max(prices[ind] + solve(ind + 1, 1, capacity - 1, n, prices), 0 + solve(ind + 1, 0, capacity, n, prices));
//         }
//         return profit;
//     }
// }