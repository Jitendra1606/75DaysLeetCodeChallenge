class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;

        long[] diff = new long[(int)(n + 1)];

        for(int i = 0 ; i < boosts.length ; i++){
            int first = boosts[i][0];
            int second = boosts[i][1];

            long boost = boosts[i][2];

            diff[first] += boost;

            if(second + 1 <= n)
                diff[second + 1] -= boost;
            
        }

        for(int i = 1 ; i < n ; i++){
            diff[i] = diff[i] + diff[i - 1];
        }
        
        long low = 0;
        long high = (long)1e18;
        long ans = 0;

        while(low <= high){
            long mid = low + (high - low) / 2;

            if(isPossible(monsters, mid, diff)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] arr, long mid, long[] diff){
        int n = arr.length;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > mid + diff[i])
            return false;

            mid = mid - arr[i];

            if(mid < 0) mid = 0;
        }

        return true;
    }
}