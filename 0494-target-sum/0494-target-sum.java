//this is a variant of count the no. of subsets with given sum if we see carefully
class Solution {
    public int findTargetSumWays(int[] nums, int target){

        int n = nums.length, sum = 0;
        
        for(int i = 0 ; i < n ; i++) sum += nums[i];
        
        if(sum < target) return 0;
        if((sum + target) < 0 || ((sum + target) % 2) != 0) return 0;
        
        int val = (sum + target) / 2;

        int[][] dp = new int[n + 1][val + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return countsubsets(nums, 0, val, n, dp);
    }

    public int countsubsets(int[] nums, int ind, int target, int n, int[][] dp){
        if(ind == n){
            if(target == 0){
                return 1;
            }
            return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int take = 0;
        if(nums[ind] <= target){
            take = countsubsets(nums, ind + 1, target - nums[ind], n, dp);
        }

        int notTake = countsubsets(nums, ind + 1, target, n, dp);

        return dp[ind][target] = take + notTake;
    }
}
//t.c = O(n * val)
//s.c = O(n * val)


// class Solution {
//     public int findTargetSumWays(int[] nums, int target){

//         int n = nums.length, sum = 0;
        
//         for(int i = 0 ; i < n ; i++) sum += nums[i];
        
//         if(sum < target) return 0;
//         if((sum + target) < 0 || ((sum + target) % 2) != 0) return 0;
        
//         int val = (sum + target) / 2;
        
//         return countsubsets(nums, 0, val, n);

//     }

//     public int countsubsets(int[] nums, int ind, int target, int n){

//         if(ind == n){
//             if(target == 0){
//                 return 1;
//             }
//             return 0;
//         }

//         int take = 0;
//         if(nums[ind] <= target){
//             take = countsubsets(nums, ind + 1, target - nums[ind], n);
//         }

//         int notTake = countsubsets(nums, ind + 1, target, n);

//         return take + notTake;
//     }
// }
//t.c = O(2^n)
//s.c = O(n)


//actually this sol is like just doing what the problem is asking but in this problem we need an observance
// class Solution{
//     public int findTargetSumWays(int[] nums, int target){

//         return solve(0, 0, target, nums);
//     }

//     public int solve(int ind, int sum, int target, int[] nums){
        
//         if(ind == nums.length){
        
//             if(target == sum){
//                 return 1;
//             }
//             return 0;
//         }
//         int plus = solve(ind + 1, sum + nums[ind], target, nums);
//         int minus = solve(ind + 1, sum - nums[ind], target, nums);
        
//         return plus + minus;
//     }
// }


// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int sum = 0;
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             sum += nums[i];
//         }
//         if(sum < target) return 0;
//         if((sum + target) < 0 || ((sum + target) % 2) != 0) return 0;
//         int val = (sum + target) / 2;
//         return countsubsets(nums, val, n);
//     }
//     public int countsubsets(int[] arr, int val, int n){
//         int[][] dp = new int[n + 1][val + 1];
//         for(int i = 0 ; i < n + 1 ; i++){
//             dp[i][0] = 1;
//         }
//         for(int j = 1 ; j < val + 1 ; j++){
//             dp[0][j] = 0;
//         }
//         for(int i = 1 ; i < n + 1 ; i++){
//             for(int j = 0 ; j < val + 1 ; j++){
//                 if(arr[i - 1] <= j){
//                     dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
//                 }else{
//                     dp[i][j] = dp[i - 1][j];
//                 }
//             }
//         }
//         return dp[n][val];
//     }
// }