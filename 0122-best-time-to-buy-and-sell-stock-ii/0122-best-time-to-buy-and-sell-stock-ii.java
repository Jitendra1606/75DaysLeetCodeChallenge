class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
//here we have 2 changing variables- buy/sell and indexes
        
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 1, n, prices, dp);
    }

    public int solve(int ind, int buy, int n, int[] prices, int[][] dp){
        if(ind == n) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1){

            int take = -prices[ind] + solve(ind + 1, 0, n, prices, dp);
            int notTake = 0 + solve(ind + 1, 1, n, prices, dp);

            return dp[ind][buy] = Math.max(take, notTake);
        }
        else{

            int sell = prices[ind] + solve(ind + 1, 1, n, prices, dp);
            int notSell = 0 + solve(ind + 1, 0, n, prices, dp);

            return dp[ind][buy] = Math.max(sell, notSell);
        }
    }
}







// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;
// //variable "buy" to keep track of a stock is bought prevoiusly or not
//         return solve(0, 1, n, prices);
//     }

//     public int solve(int ind, int buy, int n, int[] prices){
//         if(ind == n) return 0;

//         if(buy == 1){//means we can buy the shares right now, & here we have both choices
//             int take = -prices[ind] + solve(ind + 1, 0, n, prices);//to take it
//             int notTake = 0 + solve(ind + 1, 1, n, prices); //means we still can buy
//             //keep track and notice that "buy" variable
//             return Math.max(take, notTake);
//         }else{ //here we stil have to choices to sell it or not sell it
//             int sell = prices[ind] + solve(ind + 1, 1, n, prices);//if we are selling
//             int notSell = 0 + solve(ind + 1, 0, n, prices); //if we are not selling the share
//     //if we sell the share then add it's value and change buy to 1, means we can buy more now
//     //& if we didn't sell it now then don't change it
//             return Math.max(sell, notSell);
//         }
//     }
// }

//simple approach
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int tot = 0;

//         for (int i = 0; i < n - 1; i++) {
//             if (prices[i] < prices[i + 1])
//                 tot += prices[i + 1] - prices[i];
//         }
//         return tot;
//     }
// }
//t.c = O(n)
//s.c = O(1)

//bottom up 
// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;
//         if(n == 0) return 0;
//         int[][] dp = new int[n + 1][2];
//         dp[n][0] = dp[n][1] = 0;
//         for(int ind = n - 1 ; ind >= 0 ; ind--){
//             for(int buy = 0 ; buy <= 1 ; buy++){
//                 int profit;
//                 if(buy == 0){
//                     profit = Math.max(0 + dp[ind + 1][0], -prices[ind] + dp[ind + 1][1]);
//                 }else{
//                     profit = Math.max(0 + dp[ind + 1][1], prices[ind] + dp[ind + 1][0]);
//                 }
//                 dp[ind][buy] = profit;
//             }
//         }
//         return dp[0][0];
//     }
// }

//memoization
// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         for(int i = 0 ; i < n ; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         return solve(0, 1, n, prices, dp);
//     }
//     public int solve(int ind, int buy, int n, int[] prices, int[][] dp){
//         if(ind == n) return 0;
//         if(dp[ind][buy] != -1) return dp[ind][buy];
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, n, prices, dp), 0 + solve(ind + 1, 1, n, prices, dp));
//         }else{
//             profit = Math.max(prices[ind] + solve(ind + 1, 1, n, prices, dp), 0 + solve(ind + 1, 0, n, prices, dp));
//         }
//         dp[ind][buy] = profit;
//         return profit;
//     }
// }
