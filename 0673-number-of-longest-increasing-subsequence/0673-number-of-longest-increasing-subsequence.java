class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;

                    cnt[i] = cnt[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    cnt[i] = cnt[i] + cnt[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int cntLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                cntLIS += cnt[i];
            }
        }
        return cntLIS;
    }
}