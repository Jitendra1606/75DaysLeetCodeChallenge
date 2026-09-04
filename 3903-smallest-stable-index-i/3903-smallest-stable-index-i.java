class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int[] maxi = new int[nums.length];
        int[] mini = new int[nums.length];
        int curmax = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            curmax = Math.max(curmax, nums[i]); 
            maxi[i] = curmax;
        }
        int curmin = nums[nums.length - 1];
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            curmin = Math.min(curmin, nums[i]);
            mini[i] = curmin;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(maxi[i] - mini[i] <= k){
                return i;
            }
        }
        return -1;
    }
}