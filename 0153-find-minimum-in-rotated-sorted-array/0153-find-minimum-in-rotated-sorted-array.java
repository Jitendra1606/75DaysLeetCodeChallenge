class Solution{
    public int findMin(int[] nums){
        int n = nums.length;

        if(nums[0] <= nums[n - 1]) return nums[0];

        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){

            int mid = low + (high - low) / 2;
            
            if(nums[low] <= nums[mid]){ //left part is sorted,answer can be here alse
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }else{
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }    
}
//t.c = O(log n)
//s.c = O(1)