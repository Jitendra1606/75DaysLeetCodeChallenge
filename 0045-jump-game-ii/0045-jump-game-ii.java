class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];

        return solve(0, nums, dp);
    }
    public int solve(int ind, int[] nums, Integer[] dp){
        int n = nums.length;

        if(ind >= n - 1) return 0;

        if(dp[ind] != null) return dp[ind];

        int min = Integer.MAX_VALUE;

        for(int jump = 1 ; jump <= nums[ind] && ind + jump < n ; jump++){
            int ans = solve(ind + jump, nums, dp);

            if(ans != Integer.MAX_VALUE){
                min = Math.min(min, 1 + ans);
            }
        }
        return dp[ind] = min;
    }
}




// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         Integer[][] dp = new Integer[n][n];

//         return solve(0, 0, nums, n - 1, dp);
//     }
//     public int solve(int ind, int jumps, int[] nums, int n, Integer[][] dp){
//         if(ind >= n) return jumps;

//         if(dp[ind][jumps] != null) return dp[ind][jumps];

//         int min = Integer.MAX_VALUE;

//         for(int i = 1 ; i <= nums[ind] ; i++){
//             min = Math.min(min, solve(i + ind, jumps + 1, nums, n, dp));
//         }
//         return dp[ind][jumps] = min;
//     }
// }



// class Solution {
//     public int jump(int[] nums) {
//         return solve(0, 0, nums, nums.length - 1);
//     }
//     public int solve(int ind, int jumps, int[] nums, int n){
//         if(ind >= n) return jumps;

//         int min = Integer.MAX_VALUE;

//         for(int i = 1 ; i <= nums[ind] ; i++){
//             min = Math.min(min, solve(i + ind, jumps + 1, nums, n));
//         }
//         return min;
//     }
// }