class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer[] dp = new Integer[target + 1];

        return solve(nums, target, dp);
    }

    public int solve(int[] nums, int target, Integer[] dp){
        if(target == 0) return 1;

        if(dp[target] != null) return dp[target];

        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                ans += solve(nums, target - nums[i], dp);
            }
        }
        return dp[target] = ans;
    }
}





// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         int n = nums.length;

//         return solve(nums, target);
//     }

//     public int solve(int[] nums, int target){
//         if(target == 0) return 1;

//         int ans = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] <= target){
//                 ans += solve(nums, target - nums[i]);
//             }
//         }

//         return ans;
//     }
// }