class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int cur = k;
        for (int i = 0; i < n; i++) {
            if (nums[i] == cur)
                cur += k;
        }
        return cur;
    }
}

// class Solution {
//     public int missingMultiple(int[] nums, int k) {
//         int n = nums.length;

//         Set<Integer> set = new HashSet<>();
//         for(int num : nums) set.add(num);

//         int cur = k;
//         while(set.contains(cur)){
//             cur += k;
//         }

//         return cur;
//     }
// }