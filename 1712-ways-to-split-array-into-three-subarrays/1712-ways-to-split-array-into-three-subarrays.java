class Solution{
    static final int MOD = (int)(1e9 + 7);

    public int waysToSplit(int[] nums){
        int n = nums.length;

        int[] preSum = new int[n];
        preSum[0] = nums[0];

        for(int i = 1 ; i < n ; i++) preSum[i] = preSum[i - 1] + nums[i];

        int res = 0;
        for(int i = 1 ; i < n - 1 ; i++){
            int left = solve(preSum, preSum[i - 1], i, true);

            int right = solve(preSum, preSum[i - 1], i, false);

            if(left == -1 || right == - 1) continue;

            res = (res + (right - left + 1) % MOD) % MOD;
        }

        return res;
    }

    public int solve(int[] prefix, int leftSum, int ind, boolean searchLeft){
        int n = prefix.length;
        
        int low = ind, high = n - 2;
        int res = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int midSum = prefix[mid] - prefix[ind - 1];

            int rightSum = prefix[n - 1] - prefix[mid];

            if(leftSum <= midSum && midSum <= rightSum){
                res = mid;

                if(searchLeft){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            else if(leftSum > midSum){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
}
