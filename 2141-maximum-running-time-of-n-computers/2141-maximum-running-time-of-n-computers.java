class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;

        long sum = 0;
        for(int num : batteries) sum += num;

        long low = 0, high = sum;
        long ans = 0;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(batteries, mid, n * mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] arr, long mid, long tot){
        int n = arr.length;
        long cnt = 0;

        for(int num : arr){
            cnt += Math.min(num, mid);
        }

        return cnt >= tot;
    }
}