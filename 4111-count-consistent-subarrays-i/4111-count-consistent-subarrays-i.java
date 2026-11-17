class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int Min = Integer.MAX_VALUE;
            int And = nums[i];

            for (int j = i; j < n; j++) {
                And = (And & nums[j]);
                Min = Math.min(Min, nums[j]);

                if (Min == And)
                    cnt++;
            }
        }

        return cnt;
    }
}