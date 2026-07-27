class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0; //bcz we are given -infinity at both ends, so if
        if (nums[n - 1] > nums[n - 2])
            return n - 1; //1st ind is > 0th ind , it is peak , same for last ind

        int low = 1, high = n - 2;
        //since, we already checked for first and last element then we can shrink our space

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            if (nums[mid] < nums[mid + 1]) { //means peak lies on the right side
                low = mid + 1; //bcz array will inc for some part definitely
            } else {
                high = mid - 1; //means peak lies on the left side
            }
        }
        return -1;
    }
}

// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return 0;
//         if(nums[0] > nums[1]) return 0; //bcz we are given -infinity at both ends, so if 
//         if(nums[n - 1] > nums[n - 2]) return n - 1; //1st ind is > 0th ind , it is peak , same for last ind  

//         int l = 1, h = n - 2;
// //since, we already checked for first and last element then we can shrink our space
//         while(l <= h){

//             int mid = l + (h - l) / 2;

//             if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;

//             else if(nums[mid] > nums[mid - 1]){ //means peak lies on the right side
//                 l = mid + 1;       //bcz array will inc for some part definitely
//             }
//             else{
//                 h = mid - 1; //means peak lies on the left side
//             }
//         }
//         return -1;
//     }
// }