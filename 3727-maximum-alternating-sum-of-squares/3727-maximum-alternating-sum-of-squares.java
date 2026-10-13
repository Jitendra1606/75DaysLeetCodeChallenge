class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long tot = 0;

        for (int i = 0; i < n; i++)
            nums[i] = Math.abs(nums[i]);

        Arrays.sort(nums);

        for (int i = n / 2; i < n; i++) {
            tot += (1L * nums[i] * nums[i]);
        }

        for (int i = 0; i < n / 2; i++) {
            tot -= (1L * nums[i] * nums[i]);
        }

        return tot;
    }
}