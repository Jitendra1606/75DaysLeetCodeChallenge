class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxi = new int[n];
        int[] mini = new int[n];
        int curmax = nums[0];
        for(int i = 0 ; i < n ; i++){
            curmax = Math.max(curmax, nums[i]);
            maxi[i] = curmax;
        }
        int curmin = nums[n - 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            curmin = Math.min(curmin, nums[i]);
            mini[i] = curmin;
        }
        for(int i = 0 ; i < n ; i++){
            if(maxi[i] - mini[i] <= k) return i;
        }
        return -1;
    }
}