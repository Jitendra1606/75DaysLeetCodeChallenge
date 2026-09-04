class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] close = new int[n];
        close[0] = 1;

        for (int i = 1; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= Math.abs(nums[i] - nums[i + 1])) {
                close[i] = i - 1;
            } else {
                close[i] = i + 1;
            }
        }
        close[n - 1] = n - 2;

        int[] forward = new int[n];
        for (int i = 1 ; i < n; i++) {
            if (i == close[i - 1])
                forward[i] = 1;

            else
                forward[i] = Math.abs(nums[i] - nums[i - 1]);

            forward[i] = forward[i] + forward[i - 1];
        }

        int[] backward = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (i == close[i + 1])
                backward[i] = 1;

            else
                backward[i] = Math.abs(nums[i] - nums[i + 1]);

            backward[i] = backward[i + 1] + backward[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r) {
                ans[i] = forward[r] - forward[l];
            } else {
                ans[i] = backward[r] - backward[l];
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] minCost(int[] nums, int[][] queries) {
//         int n = nums.length;

//         int[] forward = new int[n - 1];

//         int[] backward = new int[n - 1];

//         for(int i = 0 ; i < n - 1 ; i++){

//             int diff = nums[i + 1] - nums[i];

//             //i -> i + 1, forward
//             if(i == 0 || diff < nums[i] - nums[i - 1]){
//                 forward[i] = 1;
//             }else{
//                 forward[i] = diff;
//             }

//             //i + 1 -> i
//             if(i + 1 == n - 1 || diff <= nums[i + 2] - nums[i + 1]){
//                 backward[i] = 1;
//             }else{
//                 backward[i] = diff;
//             }
//         }

//         //prefix sum
//         int[] prefor = new int[n];
//         int[] prebac = new int[n];

//         for(int i = 0 ; i < n - 1 ; i++){
//             prefor[i + 1] = prefor[i] + forward[i];

//             prebac[i + 1] = prebac[i] + backward[i]; 
//         }

//         int[] ans = new int[queries.length];

//         for(int i = 0 ; i < queries.length ; i++){
//             int start = queries[i][0];
//             int end = queries[i][1];

//             if(start < end){
//                 ans[i] = prefor[end] - prefor[start];
//             }else{
//                 ans[i] = prebac[start] - prebac[end];
//             }
//         }
//         return ans;
//     }
// }