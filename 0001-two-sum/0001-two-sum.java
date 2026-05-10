class Solution{
    public int[] twoSum(int[] nums, int target){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
//t.c = O(n)
//s.c = O(n)


// class Solution{
//     public int[] twoSum(int[] nums, int target){
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 if(nums[i] + nums[j] == target) return new int[]{i , j};
//             }
//         }
//         return new int[]{-1, -1};
//     }
// }
//t.c = O(n * n)
//s.c = O(2)