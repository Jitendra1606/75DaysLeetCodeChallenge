class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long[] pre = new long[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }

        long[] suff = new long[n];
        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i] + suff[i + 1];
        }

        //calculating total points
        long ways = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n)
                if (pre[i] >= suff[i + 1])
                    ways++;
        }
        return (int)ways;
    }
}