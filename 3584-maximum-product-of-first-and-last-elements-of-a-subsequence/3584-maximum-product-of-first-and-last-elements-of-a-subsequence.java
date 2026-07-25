class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;

        long sufMin = nums[n - 1];
        long sufMax = nums[n - 1];

        long prod = Long.MIN_VALUE;

        for (int i = n - m; i >= 0; i--) {
            sufMax = Math.max(sufMax, nums[i + m - 1]);
            sufMin = Math.min(sufMin, nums[i + m - 1]);

            if (nums[i] > 0) {
                prod = Math.max(prod, 1L * nums[i] * sufMax);
            } else {
                prod = Math.max(prod, 1L * nums[i] * sufMin);
            }
        }
        return prod;
    }
}

// class Solution{
//     public long maximumProduct(int[] nums, int m){
//         int n = nums.length;

//         int[] sufMin = new int[n];
//         sufMin[n - 1] = nums[n - 1];

//         for(int i = n - 2 ; i >= 0 ; i--){
//             sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
//         }

//         int[] sufMax = new int[n];
//         sufMax[n - 1] = nums[n - 1];

//         for(int i = n - 2 ; i >= 0 ; i--){
//             sufMax[i] = Math.max(sufMax[i + 1], nums[i]);
//         }

//         long prod = Long.MIN_VALUE;

//         for(int i = 0 ; i <= n - m ; i++){
//             if(nums[i] > 0){
//                 prod = Math.max(prod, 1L * nums[i] * sufMax[i + m - 1]);
//             }else{
//                 prod = Math.max(prod, 1L * nums[i] * sufMin[i + m - 1]);
//             }
//         }
//         return prod;
//     }
// }

// class Solution {
//     public long maximumProduct(int[] nums, int m) {
//         int n = nums.length;

//         long max = Long.MIN_VALUE;
//         for(int i = 0 ; i <= n - m ; i++){
//             for(int j = i + m - 1 ; j < n ; j++){
//                 max = Math.max(max, 1L * nums[i] * nums[j]);
//             }
//         }
//         return max;
//     }
// }