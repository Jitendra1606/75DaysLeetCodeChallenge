class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums)
            sum += x;

        if (sum % k != 0)
            return false;

        int tar = sum / k;

        boolean[] used = new boolean[n];

        return solve(0, 0, tar, nums, k, used);
    }

    public boolean solve(int ind, int cursum, int tar, int[] nums, int k, boolean[] used) {
        if (k == 1)
            return true; //k - 1 subsets are formed

        if (cursum == tar)
            return solve(0, 0, tar, nums, k - 1, used);

        for (int i = ind; i < nums.length; i++) {
            if (used[i])
                continue;

            if (nums[i] + cursum > tar)
                continue;

            used[i] = true;

            if (solve(i + 1, cursum + nums[i], tar, nums, k, used))
                return true;

            used[i] = false;
        }

        return false;
    }
}