class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        long totalCost = 0;
        for(int i = 0 ; i < n ; i++){
            totalCost += arr[i][1];
        }

        long currCost = 0;
        int target = 0;

        for(int i = 0 ; i < n ; i++){ //to find the right median
            currCost += arr[i][1];

            if(currCost * 2 >= totalCost){
                target = arr[i][0];
                break;
            }
        }

        long ans = 0;
        for(int i = 0 ; i < n ; i++){ //just simply calculating the ans
            ans += Math.abs((long)arr[i][0] - target) * arr[i][1];
        }

        return ans;
    }
}


// Σ |nums[i] - target| * cost[i]
//         ↓
//    weighted median