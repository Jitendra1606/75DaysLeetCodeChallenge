class Solution{
    public int minMoves(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int x : nums){
            sum += x;
            max = Math.max(x, max);
        }

        return n * max - sum;
    }
}


// class Solution {
//     public int minMoves(int[] nums) {
//         int n = nums.length;
//         int max = 0;

//         for(int x : nums){
//             max = Math.max(max, x);
//         }

//         int ans = 0;
//         for(int x : nums){
//             ans += Math.abs(x - max);
//         }

//         return ans;
//     }
// }