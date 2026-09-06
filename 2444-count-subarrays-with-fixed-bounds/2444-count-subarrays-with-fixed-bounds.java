class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        long ans = 0;
        int left = -1;
        long lastMax = -1, lastMin = -1;

        for (int i = 0; i < n; i++) {

            //innvalid element
            if (nums[i] < minK || nums[i] > maxK)
                left = i;

            if (nums[i] == minK)
                lastMin = i;

            if (nums[i] == maxK)
                lastMax = i;

            if (lastMin != -1 && lastMax != -1) {
                ans += Math.max(0, Math.min(lastMin, lastMax) - left);
            }
        }
        return ans;
    }
}