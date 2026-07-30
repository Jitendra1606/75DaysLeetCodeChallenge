class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n, ans = 0;

        if(k > m * n) return 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(m, n, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int m, int n, int k, int mid){
        int cnt = 0;

        for(int i = 1 ; i <= m ; i++){
            cnt += Math.min(n, (mid / i));

            if(cnt == k) return true;
        }

        return cnt >= k;
    }
}