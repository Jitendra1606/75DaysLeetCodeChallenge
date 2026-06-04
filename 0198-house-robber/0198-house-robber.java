class Solution{
    public int rob(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for(int i = 3 ; i < n + 1 ; i++){
            int temp = nums[i - 1] + dp[i - 2];
            int temp1 = dp[i - 1];
            dp[i] = Math.max(temp, temp1);
        }
        return dp[n];
    }
}

// class Solution{
//     public int rob(int[] nums){
//         int n = nums.length;
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return solve(nums, 0, dp);
//     }

//     public int solve(int[] arr, int i, int[] dp){
//         if(i >= arr.length) return 0;
//         if(i == arr.length - 1) return dp[i] = arr[arr.length - 1];

//         if(dp[i] != -1) return dp[i];

//         int pick = arr[i] + solve(arr, i + 2, dp);
//         int notPick = solve(arr, i + 1, dp);

//         return dp[i] = Math.max(pick, notPick);
//     }
// }

// class Solution{
//     public int rob(int[] nums){
//         int n = nums.length;
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return solve(nums, n - 1, dp);
//     }

//     public int solve(int[] nums, int n, int[] dp){
//         if(n == 0) return dp[0] = nums[0];
//         if(n < 0) return 0;
//         if(dp[n] != -1) return dp[n];

//         int pick = nums[n] + solve(nums, n - 2, dp);
//         int notPick = solve(nums, n - 1, dp);

//         return dp[n] = Math.max(pick, notPick);
//     }
// }

// class Solution{
//     public int rob(int[] nums){
//         int n = nums.length;
//         return solve(nums, 0, n - 1);
//     }
    
//     public int solve(int[] arr, int i, int n){
//         if(i == n) return arr[n];
//         if(i > n) return 0;

//         int pick = arr[i] + solve(arr, i + 2, n);
//         int notPick = solve(arr, i + 1, n);
        
//         return Math.max(pick, notPick);
//     }
// }

// class Solution{
//     public int rob(int[] nums){
//         int n = nums.length;
//         return solve(nums, n - 1);
//     }

//     public int solve(int[] nums, int n){
//         if(n == 0) return nums[0];

//         if(n < 0) return 0;

//         int pick = nums[n] + solve(nums, n - 2);
//         int notPick = solve(nums, n - 1);

//         return Math.max(pick, notPick);
//     }
// }
