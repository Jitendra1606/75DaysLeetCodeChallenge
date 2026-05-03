class Solution{
    public int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        int i = 0, j = n - 1;
        for(int k = n - 1 ; k >= 0 ; k--){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[k] = nums[i] * nums[i];
                i++;
            }else{
                result[k] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}

// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int n = nums.length;
//         int[] squares = new int[n];
//         for(int i = 0 ; i < n ; i++){
//             squares[i] = nums[i] * nums[i];
//         }
//         Arrays.sort(squares);
//         return squares;
//     }
// }