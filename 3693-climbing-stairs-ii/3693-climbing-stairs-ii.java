class Solution {
    public int climbStairs(int n, int[] costs) {

        Integer[] dp = new Integer[n + 1];
        return solve(0, n, costs, dp);
    }

    public int solve(int i, int n, int[] costs, Integer[] dp){
        if(i == n) return 0;
        
        if(dp[i] != null) return dp[i];

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;

        if(i + 1 <= n){
            one = (costs[i] + 1 + solve(i + 1, n, costs, dp));
        }

        if(i + 2 <= n){
            two = (costs[i + 1] + 4 + solve(i + 2, n, costs, dp));
        }

        if(i + 3 <= n){
            three = (costs[i + 2] + 9 + solve(i + 3, n, costs, dp));
        }

        return dp[i] = Math.min(one, Math.min(two, three));
    }
}