//bottom up
class Solution{
    public int maxProfit(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int ind = n - 1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
                }else{
                    profit = Math.max(prices[ind] - fee + dp[ind + 1][1], 0 + dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}

//memoization
// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         for(int[] rows : dp){
//             Arrays.fill(rows, -1);
//         }
//         return solve(0, 1, n, prices, fee, dp);
//     }
//     public int solve(int ind, int buy, int n, int[] prices, int fee, int[][] dp){
//         if(ind == n) return 0;
//         if(dp[ind][buy] != -1) return dp[ind][buy];
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, n, prices, fee, dp), 0 + solve(ind + 1, 1, n, prices, fee, dp));
//         }else{
//             profit = Math.max(prices[ind] - fee + solve(ind + 1, 1, n, prices, fee, dp), 0 + solve(ind + 1, 0, n, prices, fee, dp));
//         }
//         dp[ind][buy] = profit;
//         return profit;
//     }
// }


//recursive
// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         return solve(0, 1, n, prices, fee);
//     }
//     public int solve(int ind, int buy, int n, int[] prices, int fee){
//         if(ind == n) return 0;
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, n, prices, fee), 0 + solve(ind + 1, 1, n, prices, fee));
//         }else{
//             profit = Math.max(prices[ind] - fee + solve(ind + 1, 1, n, prices, fee), 0 + solve(ind + 1, 0, n, prices, fee));
//         }
//         return profit;
//     }
// }