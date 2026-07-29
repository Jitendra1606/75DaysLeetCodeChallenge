class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;

        for(int num : candies) max = Math.max(max, num);

        int low = 1, high = max;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(candies, mid, k)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int mid, long k){
        int n = nums.length;
        long cnt = 0;

        for(int i = 0 ; i < n ; i++){
            cnt += (nums[i] / mid);
        }

        return cnt >= k;
    }
}