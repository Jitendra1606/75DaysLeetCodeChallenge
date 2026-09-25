class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        int cnt = 1;
        int prev = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != prev) {
                cnt++;
                prev = nums[i];
            }

            if (cnt == 3)
                return nums[i];
        }

        return nums[0];
    }
}