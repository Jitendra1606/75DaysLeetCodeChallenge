// //again exactly same logic as "Number of Longest Increasing Subsequence"

// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         int n = pairs.length;

//         Arrays.sort(pairs, (a, b) -> {
//             if(a[0] == b[0]) return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         int[] dp = new int[n];
//         Arrays.fill(dp, 1); //bcz in starting everyone has length 1

//         int maxLen = 0;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < i ; j++){
//                 if(pairs[j][1] < pairs[i][0]){
//                     if(dp[i] < dp[j] + 1){
//                         dp[i] = dp[j] + 1;
//                     }
//                 }
//             }
//             maxLen = Math.max(maxLen, dp[i]);
//         }
//         return maxLen;
//     }
// }


//slight easy approach
class Solution{
    public int findLongestChain(int[][] pairs){
        int n = pairs.length;

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int chainCnt = 1;
        int maxEnd = pairs[0][1];

        for(int i = 1 ; i < n ; i++){
            if(pairs[i][0] > maxEnd){
                chainCnt += 1;
                maxEnd = pairs[i][1];
            }
        }
        return chainCnt;
    }
}