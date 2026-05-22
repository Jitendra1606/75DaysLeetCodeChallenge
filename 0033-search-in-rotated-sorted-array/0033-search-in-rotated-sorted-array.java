//here the array is rotated so any part is sorted like left or right [4,5,6,1,2,3] till 6 is sorted and then from 1 till 3 so we just need an extra if condition to check which part is sorted and in that portion our target lies or not
class Solution{
    public int search(int[] nums, int target){
        int n = nums.length;
        
        int l = 0, h = n - 1;

        while(l <= h){

            int mid = l + (h - l) / 2;

            if(nums[mid] == target) return mid;

            else if(nums[l] <= nums[mid]){ //means left part is sorted

                if(nums[l] <= target && target <= nums[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{ //right part is sorted
 
                if(nums[mid + 1] <= target && target <= nums[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
//t.c = O(log n)
//s.c = O(1)