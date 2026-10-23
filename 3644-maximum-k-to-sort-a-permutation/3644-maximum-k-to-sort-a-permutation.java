class Solution{
    public int sortPermutation(int[] nums){
        int n = nums.length;
        int ans = -1;

        for(int i = 0 ; i < n ; i++){
            if(i != nums[i]){
                ans &= nums[i];
            }
        }

        return Math.max(0, ans);
    }
}

// class Solution {
//     public int sortPermutation(int[] nums) {
//         int n = nums.length;

//         boolean[] hash = new boolean[n];
//         boolean flag = false;

//         for (int i = 0; i < n; i++) {
//             if (nums[i] == i)
//                 hash[i] = true;
//             else {
//                 hash[i] = false;
//                 flag = true;
//             }
//         }

//         if (flag == false)
//             return 0;

//         boolean flag1 = false;
//         int and = 0;
//         for (int i = 0; i < n; i++) {
//             if (flag1 == false && hash[i] == false) {
//                 and = (i & i);
//                 flag1 = true;
//             }

//             else if (flag1 == true && hash[i] == false)
//                 and = (and & i);
//         }

//         return and;
//     }
// }