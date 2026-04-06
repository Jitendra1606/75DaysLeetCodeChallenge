class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n - 1]) return nums[0];
        int start = 0, end = n - 1;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[start] <= nums[mid]){//means left part is sorted, so first element must be sorted
                ans = Math.min(ans, nums[start]);
                start = mid + 1; //our potential can be ahead of this also
            }else{
                end = mid - 1;
                ans = Math.min(ans, nums[mid]); //means it can be in the right part and first element here also is the smallest, and we need to check beyond from here
            }
        }
        return ans;
    }
}