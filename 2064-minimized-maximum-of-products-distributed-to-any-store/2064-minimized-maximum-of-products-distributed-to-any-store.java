class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;

        int max = 0;
        for(int num : quantities) max = Math.max(max, num);

        int low = 1, high = max;
        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(quantities, mid, n)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int mid, int k){
        int m = nums.length;
        int cnt = 0;

        for(int i = 0 ; i < m ; i++){
            cnt += ((nums[i] + mid - 1) / mid);
        }

        return cnt <= k;
    }
}