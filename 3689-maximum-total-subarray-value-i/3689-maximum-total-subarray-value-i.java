class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return k * (max - min);
    }
}
//t.c = O(n)
//s.c = O(1)