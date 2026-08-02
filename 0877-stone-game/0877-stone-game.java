//exactly same concept as "predict the winner"
class Solution{
    public boolean stoneGame(int[] piles){
        int n = piles.length;

        Integer[][] dp = new Integer[n][n];

        int ans = solve(0, n - 1, piles, dp);

        return ans >= 0;
    }

    public int solve(int i, int j, int[] arr, Integer[][] dp){
        if(i == j) return arr[i];

        if(dp[i][j] != null) return dp[i][j];

        int takeLeft = arr[i] - solve(i + 1, j, arr, dp);
        int takeRight = arr[j] - solve(i, j - 1, arr, dp);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}





// class Solution {
//     public boolean stoneGame(int[] piles) {
//         int n = piles.length;

//         Integer[][] dp = new Integer[n][n];

//         int ans = solve(0, n - 1, piles, dp);
//         return ans >= 0;
//     }

//     public int solve(int i, int j, int[] nums, Integer[][] dp){
//         if(i == j) return nums[i]; //means only 1 player left

//         if(dp[i][j] != null) return dp[i][j];

//         int takeLeft = nums[i] - solve(i + 1, j, nums, dp);
//         int takeRight = nums[j] - solve(i, j - 1, nums, dp);

//         return dp[i][j] = Math.max(takeLeft, takeRight);
//     }
// }





// class Solution {
//     public boolean stoneGame(int[] piles) {
//         int n = piles.length;

//         int ans = solve(0, n - 1, piles);
//         return ans >= 0;
//     }

//     public int solve(int i, int j, int[] nums){
//         if(i == j) return nums[i]; //means only 1 player left

//         int takeLeft = nums[i] - solve(i + 1, j, nums);
//         int takeRight = nums[j] - solve(i, j - 1, nums);

//         return Math.max(takeLeft, takeRight);
//     }
// }