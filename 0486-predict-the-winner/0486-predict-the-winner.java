class Solution{
    
    public boolean predictTheWinner(int[] nums){
        int n = nums.length;

        Integer[][] dp = new Integer[n][n];

        int ans = solve(0, n - 1, nums, dp);
        return ans >= 0;
    }

    public int solve(int i, int j, int[] nums, Integer[][] dp){
        if(i == j) return nums[i]; //when only one element left

        if(dp[i][j] != null) return dp[i][j];

        int left = nums[i] - solve(i + 1, j, nums, dp);

        int right = nums[j] - solve(i, j - 1, nums, dp);

        return dp[i][j] = Math.max(left, right);
    }
}


// class Solution{
//     public boolean predictTheWinner(int[] nums){
//         int n = nums.length;

//         int ans = solve(0, n - 1, nums);
//         return ans >= 0;
//     }

//     public int solve(int i, int j, int[] nums){
//         if(i == j) return nums[i]; //when only one element left

//         int left = nums[i] - solve(i + 1, j, nums);

//         int right = nums[j] - solve(i, j - 1, nums);

//         return Math.max(left, right);
//     }
// }
//Because the recursion returns: that's why for +ve ans A is winning
// (current player score) - (other player score) (NOT the actual score.)

// class Solution{
//     public boolean predictTheWinner(int[] nums){
//         int n = nums.length;
//         int[][] dp = new int[n][n];

//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(nums, 0, n - 1, dp) >= 0 ;
//     }

//     public int solve(int[] nums, int i, int j, int[][] dp){
//         if(i == j) return dp[i][j] = nums[i];

//         if(dp[i][j] != -1) return dp[i][j];

//         int left = nums[i] - solve(nums, i + 1, j, dp);
//         int right = nums[j] - solve(nums, i, j - 1, dp);

//         return dp[i][j] = Math.max(left, right);
//     }
// }