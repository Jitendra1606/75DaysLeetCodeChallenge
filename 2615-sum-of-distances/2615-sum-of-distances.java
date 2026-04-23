class Solution{
    public long[] distance(int[] nums){
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, Long> indexSum = new HashMap<>();
        HashMap<Integer, Long> indexCount = new HashMap<>();

        //first going left to right
        for(int i = 0 ; i < n ; i++){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            ans[i] = ans[i] + (freq * i - sum); // derived formula

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }
        //either we can make two more new maps or we can just reuse above two
        indexSum.clear();
        indexCount.clear();

        //now going left to right
        for(int i = n - 1 ; i >= 0 ; i--){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            ans[i] = ans[i] + (sum - freq * i);

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }
        return ans;
    }
}


// brute force(tle - 1065/ 1068 test case)
// class Solution {
//     public long[] distance(int[] nums) {
//         int n = nums.length;
//         long[] ans = new long[n];
//         for(int i = 0 ; i < n ; i++){
//             long sum = 0;
//             for(int j = 0 ; j < n ; j++){
//                 if(i == j) continue;
//                 if(nums[i] == nums[j]){
//                     sum += Math.abs(i - j);
//                 }
//             }
//             ans[i] = sum;
//         }
//         return ans;
//     }
// }