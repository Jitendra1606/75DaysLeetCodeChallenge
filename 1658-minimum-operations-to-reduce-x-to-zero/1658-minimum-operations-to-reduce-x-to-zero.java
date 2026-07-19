class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int tot = 0;
        for(int i = 0 ; i < n ; i++){
            tot += nums[i];
        }

        int target = tot - x; //we need to find longest subarray with sum = target

        if(target < 0) return -1;
        if(target == 0) return n;

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}