class Solution{
    public int subarraySum(int[] nums, int k){
        int n = nums.length;
        int sum = 0, cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //sum = 0, comes 1 time till now

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}


//brute force
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         for(int i = 0 ; i < n ; i++){
//             int sum = 0;
//             for(int j = i ; j < n ; j++){
//                 sum += nums[j];
//                 if(sum == k){
//                     cnt++;
//                     break;
//                 }
//             }
//         }
//         return cnt;
//     }
// }