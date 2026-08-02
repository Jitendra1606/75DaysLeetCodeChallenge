class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;

        int[] ans = new int[m];

        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + tasks[i];
        }

        long curr = 0;

        for (int i = 0; i < m; i++) {
            curr += shifts[i];

            if (curr >= pre[n]) {
                ans[i] = 0;
                curr = 0; // restart
                continue;
            }

            int j = upperBound(pre, curr);
            ans[i] = n - j + 1;
        }

        return ans;
    }

    private int upperBound(long[] pre, long target) {
        int left = 0, right = pre.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (pre[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}