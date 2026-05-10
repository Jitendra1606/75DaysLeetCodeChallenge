class Solution{
    public int maxSubArray(int[] nums){
        
        int n = nums.length;
        int sum = 0, max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
//t.c = O(n)
//s.c = O(1)

// tle
// class Solution{
//     public int maxSubArray(int[] nums){
//         int n = nums.length, max = Integer.MIN_VALUE;
//         for(int i = 0 ; i < n ; i++){
//             int sum = 0;
//             for(int j = i ; j < n ; j++){
//                 sum += nums[j];
//                 max = Math.max(max, sum);
//                 // if(sum < 0) sum = 0;
//             }
//         }
//         return max;
//     }
// }
//t.c = O(n * n)
//s.c = O(1)