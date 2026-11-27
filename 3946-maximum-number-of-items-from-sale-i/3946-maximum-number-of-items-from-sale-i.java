class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        int[][][] dp = new int[n][budget + 1][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (items[j][0] % items[i][0] == 0)
                        free[i]++;
                }
            }
        }

        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }

        return solve(0, items, budget, free, 0, dp);
    }

    public int solve(int ind, int[][] items, int bud, int[] free, int taken, int[][][] dp){
        if(ind == items.length) return 0;

        if(dp[ind][bud][taken] != -1) return dp[ind][bud][taken];

        int notTake = solve(ind + 1, items, bud, free, 0, dp);

        int take = 0;
        if(items[ind][1] <= bud){

            if(taken == 0){
                take = 1 + free[ind] + solve(ind, items, bud - items[ind][1], free, 1, dp);
            }
            else{
                take = 1 + solve(ind, items, bud - items[ind][1], free, 1, dp);
            }
        }
        return dp[ind][bud][taken] = Math.max(take, notTake);
    }
}