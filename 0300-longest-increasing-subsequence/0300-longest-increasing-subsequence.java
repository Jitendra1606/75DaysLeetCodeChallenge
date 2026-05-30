class Solution{
    public int lengthOfLIS(int[] nums){
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int ind = n - 1 ; ind >= 0 ; ind--){
            for(int prev = ind - 1 ; prev >= -1 ; prev--){

                int len = 0 + dp[ind + 1][prev + 1];
                if(prev == -1 || nums[ind] > nums[prev]){
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                }

                dp[ind][prev + 1] = len;
            }
        }
        return dp[0][0];
    }
}





//memoization
// class Solution{
//     public int lengthOfLIS(int[] nums){
//         int n = nums.length;

//         int[][] dp = new int[n][n + 1];
//         for(int[] row : dp) Arrays.fill(row, -1);

// //0 is for current ind, -1 is to keep track of prev ind
//         return solve(0, -1, nums, dp);
//     }

//     public int solve(int ind, int prev, int[] nums, int[][] dp){
//         if(ind == nums.length) return 0;

//         if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
// //with prev + 1, we're doing shifting of ind as we need -1 so we make -1 to 0
//         int take = 0;
//         if(prev == -1 || nums[ind] > nums[prev]){
//             take = 1 + solve(ind + 1, ind, nums, dp);
//         }
//         int notTake = 0 + solve(ind + 1, prev, nums, dp);

//         return dp[ind][prev + 1] = Math.max(take, notTake);
//     }
// }



//recursive
// class Solution{
//     public int lengthOfLIS(int[] nums){
//         int n = nums.length;

//         return solve(0, -1, nums);
//     }

//     public int solve(int ind, int prev, int[] nums){
//         if(ind == nums.length) return 0;

//         int take = 0;
//         if(prev == -1 || nums[ind] > nums[prev]){
//             take = 1 + solve(ind + 1, ind, nums);
//         }
//         int notTake = 0 + solve(ind + 1, prev, nums);

//         return Math.max(take, notTake);
//     }
// }
//t.c = O(2^n)
//s.c = O(n)
