class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int low = max, high = sum;
        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int sub, int k) {
        int cnt = 1, subSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (subSum + nums[i] > sub) {
                cnt++;
                subSum = nums[i];
            } else {
                subSum += nums[i];
            }
            if (cnt > k)
                return false;
        }
        return true;
    }
}
//t.c = O(nlog(sum(nums)))
//s.c = O(1)