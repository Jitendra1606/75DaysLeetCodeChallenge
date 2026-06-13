class Solution {
    int mod = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length;

        Integer[][][] dp = new Integer[m][n + 1][minProfit + 1];

        return solve(0, 0, 0, group, profit, minProfit, n, dp);
    }

    public int solve(int ind, int netProfit, int groupPeople, int[] group, int[] profit, int minProfit, int n, Integer[][][] dp){
        if(ind == profit.length){
            if(netProfit >= minProfit) return 1;

            return 0;
        }

        if(dp[ind][groupPeople][netProfit] != null) return dp[ind][groupPeople][netProfit]; 

        int notTake = solve(ind + 1, netProfit, groupPeople, group, profit, minProfit, n, dp);

        int take = 0;
        if(groupPeople + group[ind] <= n){
            int newProfit = Math.min(minProfit, netProfit + profit[ind]);
            take = solve(ind + 1, newProfit, groupPeople + group[ind], group , profit, minProfit, n, dp);
        }
        

        return dp[ind][groupPeople][netProfit] = (take + notTake) % mod;
    }
}