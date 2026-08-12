class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0, maxLen = 0;

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;

            }

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}