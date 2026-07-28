class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (n < m * k)
            return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int ans = -1;

        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int mid, int m, int k) {
        int n = nums.length;

        int cnt = 0, bouquets = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                cnt++;

                if (cnt == k) {
                    bouquets++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return bouquets >= m;
    }
}

// class Solution {
//     public int minDays(int[] bloomDay, int m, int k) {
//         int n = bloomDay.length;

//         if(n < (long)m * (long)k) return -1;

//         int min = Integer.MAX_VALUE ,max = Integer.MIN_VALUE;
//         for(int i = 0 ; i < n ; i++){
//             min = Math.min(min, bloomDay[i]);
//             max = Math.max(max, bloomDay[i]);
//         }

//         int low = min, high = max;
//         int ans = high;

//         while(low <= high){

//             int mid = low + (high - low) / 2;

//             if(isPossible(bloomDay, mid, m, k)){
//                 ans = mid;
//                 high = mid - 1;
//             }
//             else{
//                 low = mid + 1;
//             }
//         }
//         return ans;
//     }

//     public boolean isPossible(int[] arr, int day, int m, int k){
//         int n = arr.length, cnt = 0, totalDays = 0;

//         for(int i = 0 ; i < n ; i++){
//             if(arr[i] <= day){
//                 cnt++;
//             }
//             else{
//                 totalDays += (cnt / k);
//                 cnt = 0;
//             }
//         }
//         totalDays += (cnt / k);
//         return totalDays >= m;
//     }
// }