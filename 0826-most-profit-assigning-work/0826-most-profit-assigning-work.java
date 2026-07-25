class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int[][] job = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        Arrays.sort(job, (a, b) -> a[0] - b[0]);

        //prefix max profit
        for(int i = 1 ; i < n ; i++){
            job[i][1] = Math.max(job[i][1], job[i - 1][1]); 
        }

        int max = 0;

        for(int i = 0 ; i < m ; i++){
            int ans = floor(job, worker[i]);

            if(ans != -1)
            max += (job[ans][1]);
        }
        return max;
    }

    public int floor(int[][] arr, int target){
        int n = arr.length;

        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid][0] <= target){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}