class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        int[] hash = new int[101];
        hash[nums[0]]++;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1])
                hash[nums[i]]++;
        }

        for (int num : hash) {
            if (num == 1)
                cnt++;
        }

        return cnt;
    }
}