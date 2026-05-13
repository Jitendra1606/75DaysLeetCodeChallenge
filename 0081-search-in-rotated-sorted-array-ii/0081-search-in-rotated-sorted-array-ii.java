//exactly same approach as 1st part just an additional edge case
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int l = 0, h = n - 1;

        while(l <= h){
            int mid = l + (h - l) / 2;

            if(nums[mid] == target) return true;

            if(nums[l] == nums[mid] && nums[mid] == nums[h]){ //edge case [3,1,2,3,3,3,3], here
                l++;  //how we can say which part is sorted ? bcz a[l] = a[mid] = a[h]
                h--;  // so we'll trim down our search space and then normally do the bs
                continue;
            }

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }
        return false;
    }
}