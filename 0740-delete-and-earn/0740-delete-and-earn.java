class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int x : nums){
            max = Math.max(max, x);
        }

        //now this problem is converted to house robber(e.g= [2,2,3,3,3,4])
        int[] arr = new int[max + 1];
        for(int x : nums){
            arr[x] += x;
        }

        Integer[] dp = new Integer[max + 1];

        return solve(max, arr, dp);
    }

    public int solve(int ind, int[] nums, Integer[] dp){
        if(ind <= 0) return 0;

        if(dp[ind] != null) return dp[ind];

        int pick = nums[ind] + solve(ind - 2, nums, dp);
        int notPick = solve(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}




//tle at 24/52
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         int max = 0;

//         for(int x : nums){
//             max = Math.max(max, x);
//         }

//         //now this problem is converted to house robber(e.g= [2,2,3,3,3,4])
//         int[] arr = new int[max + 1];
//         for(int x : nums){
//             arr[x] += x;
//         }

//         return solve(max, arr);
//     }

//     public int solve(int ind, int[] nums){
//         if(ind <= 0) return 0;

//         int pick = nums[ind] + solve(ind - 2, nums);
//         int notPick = solve(ind - 1, nums);

//         return Math.max(pick, notPick);
//     }
// }