class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        Integer[] dp = new Integer[n];

        return solve(0, n, days, costs, dp);
    }

    public int solve(int ind, int n, int[] days, int[] cost, Integer[] dp){
        if(ind >= n) return 0;

        if(dp[ind] != null) return dp[ind];

        int min = Integer.MAX_VALUE;

        int oneDay = cost[0] + solve(ind + 1, n, days, cost, dp);

        int i = ind;
        while(i < n && days[i] <= days[ind] + 6){
            i++;
        }
        int sevenDays = cost[1] + solve(i, n, days, cost, dp);

        i = ind;
        while(i < n && days[i] <= days[ind] + 29){
            i++;
        }
        int thirtyDays = cost[2] + solve(i, n, days, cost, dp);

        return dp[ind] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
}