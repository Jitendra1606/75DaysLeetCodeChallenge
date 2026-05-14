class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int sum = 0, max = Integer.MIN_VALUE;   
        for(int i = 0 ; i < n ; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int low = max, high = sum;
        int ans = max;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int weight, int days){
        int n = nums.length, day = 1, load = 0;

        for(int i = 0 ; i < n ; i++){
            if(load + nums[i] > weight){
                day++;
                load = nums[i];
            }else{
                load = load + nums[i];
            }
        }
        return day <= days;
    }
}