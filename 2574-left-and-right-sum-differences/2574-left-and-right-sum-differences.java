class Solution{
    public int[] leftRightDifference(int[] nums){
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        int[] ans = new int[n];

        for(int num : nums) sum1 += num;

        for(int i = 0 ; i < n ; i++){
            sum1 -= nums[i];

            ans[i] = Math.abs(sum1 - sum2);

            sum2 += nums[i];
        }
        return ans;
    }
}



// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n  = nums.length;

//         int[] left = new int[n];
//         int[] right = new int[n];
//         int[] ans = new int[n];

//         left[0] = 0;
//         right[n - 1] = 0;

//         int sum1 = 0;
//         for(int i = 1 ; i < n ; i++){
//             sum1 += nums[i - 1];
//             left[i] = sum1;
//         }

//         int sum2 = 0;
//         for(int i = n - 2 ; i >= 0 ; i--){
//             sum2 += nums[i + 1];
//             right[i] = sum2;
//         }

//         for(int i = 0 ; i < n ; i++){
//             ans[i] = Math.abs(left[i] - right[i]);
//         }
//         return ans;
//     }
// }