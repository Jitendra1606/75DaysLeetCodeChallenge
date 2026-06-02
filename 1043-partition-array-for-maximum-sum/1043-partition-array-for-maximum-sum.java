class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, arr, k, dp);
    }

    public int solve(int ind, int[] arr, int k, int[] dp){
        if(ind == arr.length) return 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        int max_ans = Integer.MIN_VALUE;

        if(dp[ind] != -1) return dp[ind];

        for(int j = ind ; j < Math.min(arr.length, ind + k) ; j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = len * max + solve(j + 1, arr, k, dp);

            max_ans = Math.max(max_ans, sum);
        }
        return dp[ind] = max_ans;
    }
}



// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int n = arr.length;
//         return solve(0, arr, k);
//     }

//     public int solve(int ind, int[] arr, int k){
//         if(ind == arr.length) return 0;
//         int len = 0;
//         int max = Integer.MIN_VALUE;
//         int max_ans = Integer.MIN_VALUE;

//         for(int j = ind ; j < Math.min(arr.length, ind + k) ; j++){
//             len++;
//             max = Math.max(max, arr[j]);
//             int sum = len * max + solve(j + 1, arr, k);

//             max_ans = Math.max(max_ans, sum);
//         }
//         return max_ans;
//     }
// }