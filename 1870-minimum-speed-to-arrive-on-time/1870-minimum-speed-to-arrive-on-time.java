class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        if(hour <= n - 1) return -1;

        int low = 1, high = 10_000_000, ans = -1;
        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(dist, mid, hour)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] arr, int mid, double k){
        int n = arr.length;
        double time = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            time += Math.ceil((double)arr[i] / mid);
        }

        time += (double)arr[n - 1] / mid;

        return time <= k;
    }
}