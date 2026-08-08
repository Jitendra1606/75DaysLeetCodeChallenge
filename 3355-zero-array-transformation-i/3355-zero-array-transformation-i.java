class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];

            diff[first] -= 1;

            if (second + 1 <= n) {
                diff[second + 1] += 1;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }

        for (int i = 0; i < n; i++) {
            if (diff[i] + nums[i] > 0)
                return false;
        }
        return true;
    }
}

// Since diff[i] is negative, we need:

// -diff[i] >= nums[i]

// or equivalently:

// diff[i] + nums[i] <= 0