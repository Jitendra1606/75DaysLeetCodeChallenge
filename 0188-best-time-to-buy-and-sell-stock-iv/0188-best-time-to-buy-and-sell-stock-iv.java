class Solution{
    public int maxProfit(int k, int[] prices){
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        for(int ind = n - 1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                for(int cnt = 1 ; cnt <= k ; cnt++){
                    if(buy == 1){
                        dp[ind][buy][cnt] = Math.max(-prices[ind] + dp[ind + 1][0][cnt], dp[ind + 1][1][cnt]);
                    }
                    else{
                        dp[ind][buy][cnt] = Math.max(prices[ind] + dp[ind + 1][1][cnt - 1], dp[ind + 1][0][cnt]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}


//memoization
// class Solution{
//     public int maxProfit(int k, int[] prices){
//         int n = prices.length;

//         int[][][] dp = new int[n + 1][2][k + 1];
//         for(int[][] rows : dp){
//             for(int[] row : rows){
//                 Arrays.fill(row, -1);
//             }
//         }

//         return solve(0, 1, k, n, prices, dp);
//     }

//     public int solve(int ind, int buy, int k, int n, int[] prices, int[][][] dp){
//         if(ind == n) return 0;
//         if(k == 0) return 0;

//         if(dp[ind][buy][k] != -1) return dp[ind][buy][k];

//         if(buy == 1){

//             int take = -prices[ind] + solve(ind + 1, 0, k, n, prices, dp);
//             int notTake = 0 + solve(ind + 1, 1, k, n, prices, dp);

//             return dp[ind][buy][k] = Math.max(take, notTake);
//         }
//         else{

//             int sell = prices[ind] + solve(ind + 1, 1, k - 1, n, prices, dp);
//             int notSell = 0 + solve(ind + 1, 0, k, n, prices, dp);

//             return dp[ind][buy][k] = Math.max(sell, notSell);
//         }
//     }
// }


//recursive
// class Solution{
//     public int maxProfit(int k, int[] prices){
//         int n = prices.length;

//         return solve(0, 1, k, n, prices);
//     }

//     public int solve(int ind, int buy, int k, int n, int[] prices){
//         if(ind == n) return 0;
//         if(k == 0) return 0;

//         if(buy == 1){

//             int take = -prices[ind] + solve(ind + 1, 0, k, n, prices);
//             int notTake = 0 + solve(ind + 1, 1, k, n, prices);

//             return Math.max(take, notTake);
//         }
//         else{

//             int sell = prices[ind] + solve(ind + 1, 1, k - 1, n, prices);
//             int notSell = 0 + solve(ind + 1, 0, k, n, prices);

//             return Math.max(sell, notSell);
//         }
//     }
// }
