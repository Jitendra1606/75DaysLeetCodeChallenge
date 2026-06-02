class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        if(n == 2){
            if(cost[0] < cost[1])return cost[0];
            else return cost[1];
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int one = solve(0, n, cost, dp);
        
        Arrays.fill(dp, -1);
        int two = solve(1, n, cost, dp);

        return Math.min(one, two);
    }

    public int solve(int ind, int n, int[] cost, int[] dp){
        if(ind >= n) return 0;

        if(dp[ind] != -1) return dp[ind];
 
        int one = cost[ind] + solve(ind + 1, n, cost, dp);
        int two = 0;
        if(ind < n){
            two = cost[ind] + solve(ind + 2, n, cost, dp);
        }
        return dp[ind] = Math.min(one, two);
    }
}