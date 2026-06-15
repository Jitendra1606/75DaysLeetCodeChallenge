// This problem is basically:
// "Convert a 2D LIS problem into a 1D LIS problem by sorting carefully."
// Sort by (width ↑, height ↓).
// Throw away the widths.
// Find the LIS of the heights.
// That's the whole trick that makes the problem solvable in O(n log n) instead of O(n²)


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]); // descending height
            return Integer.compare(a[0], b[0]); // ascending width
        });

        List<Integer> list = new ArrayList<>();

        for(int[] env : envelopes){
            int h = env[1];

            int left = 0;
            int right = list.size();

            //lowerBound: first index with value >= h
            while(left < right){
                int mid = left + (right - left) / 2;

                if(list.get(mid) < h){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            if(left == list.size()){
                list.add(h);
            }else{
                list.set(left, h);
            }
        }
        return list.size();
        
    }
}

//again exactly same logic as "Number of Longest Increasing Subsequence" , but this gives us tle
// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         int n = envelopes.length;

//         Arrays.sort(envelopes, (a, b) -> {
//             if(a[0] == b[0]) return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int maxBox = 1;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < i ; j++){
//                 if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
//                     if(dp[i] < dp[j] + 1){
//                         dp[i] = dp[j] + 1;
//                     }
//                 }
//             }
//             maxBox = Math.max(maxBox, dp[i]);
//         }
//         return maxBox;
//     }
// }