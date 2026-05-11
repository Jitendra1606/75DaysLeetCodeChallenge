class Solution{
    public int subarraySum(int[] nums, int k){

        int n = nums.length, sum = 0, cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); //till now sum 0 has comes 1 time

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
//t.c = O(n)
//s.c = O(n)(hashmap)


//brute force
// class Solution{
//     public int subarraySum(int[] nums, int k){
//         int n = nums.length, cnt = 0;
//         for(int i = 0 ; i < n ; i++){
//             int sum = 0;
//             for(int j = i ; j < n ; j++){
//                 sum += nums[j];
//                 if(sum == k){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }
//t.c = O(n * n)
//s.c = O(1)