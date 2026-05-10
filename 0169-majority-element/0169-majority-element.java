//moore's voting algorithm
class Solution{
    public int majorityElement(int[] nums){
        int n = nums.length;
        int cnt = 0, element = 0;
        for(int i = 0 ; i < n ; i++){
            if(cnt == 0){
                cnt = 1;
                element = nums[i];
            }else if(nums[i] == element){
                cnt++;
            }else{
                cnt--;
            }
        }
        return element;
    }
}
//t.c = O(n)
//s.c = O(1)

// class Solution{
//     public int majorityElement(int[] nums){
//         int n = nums.length;
//         int max = n / 2;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0 ; i < n ; i++){
//             map.put(nums[i], map.getOrDefault(nums[i] , 0) + 1);
//             if(map.get(nums[i]) > max) return nums[i];
//         }
//         return -1;
//     }
// }
//t.c = O(n)
//s.c = O(n) (for hashmap)