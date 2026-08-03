class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        Integer[] dp = new Integer[n];

        int ans = solve(0, stoneValue, dp);

        if(ans > 0) return "Alice";
        else if(ans < 0) return "Bob";
        else return "Tie";
    }

    public int solve(int i, int[] arr, Integer[] dp){
        int n = arr.length;

        if(i >= n) return 0;

        if(dp[i] != null) return dp[i];

        int take = 0;
        int maxDiff = Integer.MIN_VALUE;

        for(int k = 0 ; k < 3 && i + k < n ; k++){
            take += arr[i + k];

            maxDiff = Math.max(maxDiff, take - solve(i + k + 1, arr, dp));
        }

        return dp[i] = maxDiff;
    }
}