//bottom up
class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for(int ind = n - 1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                if(buy == 1){
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                }else{
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}



//memoization
// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;

//         int[][] dp = new int[n + 1][2];
//         for(int[] row : dp) Arrays.fill(row, -1);

//         return solve(0, 1, n, prices, dp);
//     }

//     public int solve(int ind, int buy, int n, int[] prices, int[][] dp){
//         if(ind >= n) return 0;

//         if(dp[ind][buy] != -1) return dp[ind][buy];

//         if(buy == 1){
//             int take = -prices[ind] + solve(ind + 1, 0, n, prices, dp);
//             int notTake = 0 + solve(ind + 1, 1, n, prices, dp);
            
//             return dp[ind][buy] = Math.max(take, notTake);
//         }
//         else{
//             int sell = prices[ind] + solve(ind + 2, 1, n, prices, dp);
//             int notSell = 0 + solve(ind + 1, 0, n, prices, dp);

//             return dp[ind][buy] = Math.max(sell, notSell);
//         }
//     }
// }



//recusrive
// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;

//         return solve(0, 1, n, prices);
//     }

//     public int solve(int ind, int buy, int n, int[] prices){
//         if(ind >= n) return 0;

//         if(buy == 1){
//             int take = -prices[ind] + solve(ind + 1, 0, n, prices);
//             int notTake = 0 + solve(ind + 1, 1, n, prices);
            
//             return Math.max(take, notTake);
//         }
//         else{
//             int sell = prices[ind] + solve(ind + 2, 1, n, prices);
//             int notSell = 0 + solve(ind + 1, 0, n, prices);

//             return Math.max(sell, notSell);
//         }
//     }
// }
