class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;

        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}

// class Solution {
//     public int maxProduct(int[] nums) {
//         int n = nums.length;

//         if(n == 1) return 0;
//         Arrays.sort(nums);

//         return (nums[n - 1] - 1) * (nums[n - 2] - 1);
//     }
// }