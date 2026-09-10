class Solution {
    static final long MOD = 1_000_000_007L;
    Long[] dp;

    public int countHousePlacements(int n) {
        dp = new Long[n + 1];

        long ans = solve(n);

        return (int)((ans * ans) % MOD);
    }

    public long solve(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;

        if (dp[n] != null)
            return dp[n];

        return dp[n] = (solve(n - 1) + solve(n - 2)) % MOD;
    }
}