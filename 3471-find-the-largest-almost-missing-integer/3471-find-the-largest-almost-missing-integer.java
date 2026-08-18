class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int max = -1, maxi = -1;

        int[] hash = new int[51];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
            maxi = Math.max(maxi, nums[i]);
        }

        if (k == 1) {
            for (int i = 0; i < 51; i++) {
                if (hash[i] == 1)
                    max = Math.max(max, i);
            }
            return max;
        }

        else if (k == n)
            return maxi;

        else {
            if (hash[nums[0]] == 1 && hash[nums[n - 1]] == 1)
                return Math.max(nums[0], nums[n - 1]);

            if (hash[nums[0]] == 1 && hash[nums[n - 1]] > 1)
                return nums[0];

            if (hash[nums[0]] > 1 && hash[nums[n - 1]] == 1)
                return nums[n - 1];
        }
        return -1;
    }
}