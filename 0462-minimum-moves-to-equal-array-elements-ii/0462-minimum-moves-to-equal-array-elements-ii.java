class Solution {
    public int minMoves2(int[] nums) {
       int n = nums.length;

       Arrays.sort(nums);
       int median = nums[n / 2];

       int ans = 0;

       for(int x : nums){
        ans += Math.abs(x - median);
       }

       return ans;
    }
}