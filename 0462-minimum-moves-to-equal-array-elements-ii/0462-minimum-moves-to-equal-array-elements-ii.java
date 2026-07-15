class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int mid = (n - 1) / 2;
        
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += Math.abs(nums[i] - nums[mid]);
        }
        return cnt;
    }
}