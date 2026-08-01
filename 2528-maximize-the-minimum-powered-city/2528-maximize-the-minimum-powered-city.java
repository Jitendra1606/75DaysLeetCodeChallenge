class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] diff = new long[n + 1];

        for(int i = 0 ; i < n ; i++){
            int first = Math.max(0, i - r);
            int last = Math.min(n - 1, i + r);

            diff[first] += stations[i];

            if(last + 1 <= n){
                diff[last + 1] -= stations[i];
            }
        }

        //summing up
        for(int i = 1 ; i < n ; i++){
            diff[i] = diff[i - 1] + diff[i];
        }

        long low = 0, high = 0, ans = 0;

        for(int x : stations) high += x;
        high += k;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(mid, diff, k, r)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(long mid, long[] diff, int k, int r){
        int n = diff.length - 1;

        long[] add = new long[n + 1];

        long added = 0;
        long used = 0;

        for(int i = 0 ; i < n ; i++){
            
            added += add[i];

            long currPower = diff[i] + added;

            if(currPower < mid){

                long need = mid - currPower;

                used += need;

                if(used > k) return false;

                added += need;

                int end = Math.min(n, i + 2 * r + 1);

                if(end < add.length){
                    add[end] -= need;
                }
            }
        }
        return true;
    }
}