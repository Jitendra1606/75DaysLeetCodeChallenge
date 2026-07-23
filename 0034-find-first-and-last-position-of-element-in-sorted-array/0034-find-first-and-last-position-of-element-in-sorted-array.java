// //we will find both occurences seperately using binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int a = firstOccurence(nums, target);
        if (a == -1)
            return new int[] { -1, -1 };

        int b = secondOccurence(nums, target);
        return new int[] { a, b };
    }

    public int firstOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int secondOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {

//         int a = firstOccurence(nums, target);
//         if(a == -1) return new int[]{-1, -1};

//         int b = lastOccurence(nums, target);
//         return new int[]{a, b};
//     }

//     //for first occurence
//     public int firstOccurence(int[] nums, int target){
//         int n = nums.length;

//         int l = 0, e = n - 1, first = -1;

//         while(l <= e){

//             int mid = l + (e - l) / 2;

//             if(nums[mid] == target){
//                 first = mid;
//                 e = mid - 1;
//             }
//             else if(nums[mid] > target){
//                 e = mid - 1;
//             }else{
//                 l = mid + 1;
//             }
//         }
//         return first;
//     }

//     //to find the last occurence we need to check in the right
//     public int lastOccurence(int[] nums, int target){
//         int n = nums.length;

//         int l = 0, e = n - 1, last = -1;

//         while(l <= e){

//             int mid = l + (e - l) / 2;

//             if(nums[mid] == target){
//                 last = mid;
//                 l = mid + 1;
//             }
//             else if(nums[mid] < target){
//                 l = mid + 1;
//             }else{
//                 e = mid - 1;
//             }
//         }
//         return last;
//     }
// }
// //t.c = O(log n) + O(log n) ~ O(log n)
// //s.c = O(1)