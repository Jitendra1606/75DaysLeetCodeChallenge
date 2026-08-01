class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];

        //construct the array
        for(int i = 0 ; i < ranges.length ; i++){

            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            arr[left] = Math.max(arr[left], right);
        }

        int currEnd = 0, farCanReach = 0, taps = 0;

        for(int i = 0 ; i <= n ; i++){

            if(i > farCanReach) return -1;

            farCanReach = Math.max(farCanReach, arr[i]);

            if(i == currEnd){
                if(currEnd != n){
                    taps++;
                }
                
                currEnd = farCanReach;
            }
        }
        return taps;
    }
}