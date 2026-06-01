//this is a exact execution of Longest Bitonic Subsequence

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;

        int[] LIS_dp = new int[n];
        Arrays.fill(LIS_dp, 1);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j]){
                    if(LIS_dp[i] < LIS_dp[j] + 1){
                        LIS_dp[i] = LIS_dp[j] + 1;
                    }
                }
            }
        }

        int[] LDS_dp = new int[n];
        Arrays.fill(LDS_dp, 1);

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j > i ; j--){
                if(arr[j] < arr[i]){
                    if(LDS_dp[i] < LDS_dp[j] + 1){
                        LDS_dp[i] = LDS_dp[j] + 1;
                    }
                }
            }
        }

        int max = 0;

        for(int i = 0 ; i < n ; i++){
            if(LIS_dp[i] > 1 && LDS_dp[i] > 1){
                max = Math.max(max, LDS_dp[i] + LIS_dp[i] - 1);
            }
        }
        return max;
    }
}