class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;

        long min = Long.MAX_VALUE, ans = 0;

        for(int num : time) min = Math.min(min, num);
        long low = 1, high = min * (int)totalTrips;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(time, mid, totalTrips)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, long mid, long k){
        int n = nums.length;
        long cnt = 0;

        for(int i = 0 ; i < n ; i++){
            cnt += (mid / nums[i]);
        }

        return cnt >= k;
    }
}