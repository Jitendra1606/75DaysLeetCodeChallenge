//we will find the first and last occurence of given number using differnet functions
class Solution{
    public int[] searchRange(int[] nums, int target){
        int a = firstoccurence(nums,target);
        if(a == -1){
            return new int[]{-1,-1};
        }
        int b = lastoccurence(nums,target);
        return new int[]{a , b};
    }
    public int firstoccurence(int[] nums , int target){
        int n = nums.length;
        int low = 0 , high = n - 1 , first = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;//for first occurence the possible answer must be on the left side
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;
    }
    public int lastoccurence(int[] nums , int target){
        int n = nums.length;
        int low = 0 , high = n - 1 , last = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;//for last occurence the possible answer must be on the right side of the array
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last;
    }
}


// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] ans = {-1 ,-1};
//         int start = search(nums , target, true);
//         int end = search(nums, target ,false);
//         ans[0] = start;
//         ans[1] = end;
//         return ans;
//     }
//     //this function just returns the index value of target
//     int search(int[] nums, int target, boolean findsearchindex){
//         int start = 0 ;
//         int end = nums.length - 1;
//         int ans = -1;
//         while(start <= end){
//             int mid = start + (end - start)/2;
//             if(target < nums[mid]){
//                 end = mid - 1;
//             }
//             else if(target > nums[mid]){
//                 start = mid + 1;
//             }
//             else{
//                 ans = mid;
//                 if(findsearchindex){
//                     end = mid - 1;
//                 }else{
//                     start = mid + 1;
//                 }
//             }
//         }
//         return ans;
//     }
// }
