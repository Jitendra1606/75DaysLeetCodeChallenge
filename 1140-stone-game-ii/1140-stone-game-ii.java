class Solution {
    int n;
    int[] suffixSum;
    Integer[][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;

        //suffix sum
        suffixSum = new int[n];

        suffixSum[n - 1] = piles[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        dp = new Integer[n][n + 1];
        
        return solve(0, 1);
    }

    public int solve(int i, int M){
        if(i >= n) return 0; //no piles left

        if(i + 2 * M >= n) return suffixSum[i];

        if(dp[i][M] != null) return dp[i][M];

        int maxStones = 0;

        for(int x = 1 ; x <= 2 * M ; x++){
            int opponent = solve(i + x, Math.max(M, x));

            maxStones = Math.max(maxStones, suffixSum[i] - opponent);
        }
        return dp[i][M] = maxStones;
    }
}