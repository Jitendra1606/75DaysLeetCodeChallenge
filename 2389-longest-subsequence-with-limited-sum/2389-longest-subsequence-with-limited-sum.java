class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);

        int[] pre = new int[n];
        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = lowerBound(pre, queries[i]);
        }
        return ans;
    }

    public int lowerBound(int[] pre, int target) {
        int i = 0, j = pre.length - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (pre[mid] <= target) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return ans + 1;
    }
}