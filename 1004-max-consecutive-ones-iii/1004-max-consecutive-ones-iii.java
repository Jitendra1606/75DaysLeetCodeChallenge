class Solution{
    public int longestOnes(int[] nums, int k){
        int n = nums.length;
        int max = 0, cnt = 0, left = 0;

        for(int right = 0 ; right < n ; right++){
            if(nums[right] == 0){
                cnt++;
            }

            while(cnt > k){
                if(nums[left] == 0) cnt--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}






// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int left = 0, max = 0, cnt = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] == 0){
//                 cnt++;
//             }
//             //we can skip this part
//             // while(cnt > k){
//             //     if(nums[left] == 0){
//             //         cnt--;
//             //     }
//             //     left++;
//             // }
//             if(cnt > k){
//                 if(nums[left] == 0){
//                     cnt--;
//                 }
//                 left++;
//             }
//             max = Math.max(max , i - left + 1);
//         }
//         return max;
//     }
// }