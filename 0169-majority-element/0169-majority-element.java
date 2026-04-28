// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         int div = n / 2;
//         HashMap<Integer , Integer> map = new HashMap<>();
//         for(int i = 0 ; i < n ; i++){
//             map.put(nums[i],map.getOrDefault(nums[i] , 0) + 1);
            
//             if(map.get(nums[i]) > div){
//             return nums[i];
//         }
//         }
       
//         return -1;
//     }
// }
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }
}