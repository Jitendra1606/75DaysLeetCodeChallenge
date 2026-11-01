class Solution{
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int moves = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }

        for(int x : nums){
            moves += (x - min);
        }

        return moves;
    }
}


// class Solution {
//     public int minMoves(int[] nums) {
//         Arrays.sort(nums);

//         int moves = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             moves += (nums[i] - nums[0]);
//         }

//         return moves;
//     }
// }