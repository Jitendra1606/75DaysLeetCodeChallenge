// abs(i - j) + abs(j - k) + abs(k - i) == 2(k - i) , if i <= j <= k
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        if(n < 3) return -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;
            for(int i = 2 ; i < list.size() ; i++){
                minDistance = Math.min(minDistance, 2 * (list.get(i) - list.get(i - 2)));
            }
        }
        if(minDistance == Integer.MAX_VALUE){
            return -1;
        }
        return minDistance;
    }
}

// class Solution {
//     public int minimumDistance(int[] nums) {
//         int n = nums.length;
//         int absSum = 0;
//         if(n < 3) return -1;
//         int ans = Integer.MAX_VALUE;
//         boolean goodTuple = false;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 if(nums[i] != nums[j]) continue;
//                 for(int k = j + 1 ; k < n ; k++){
//                     if(nums[k] == nums[i]){
//                         absSum = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
//                         if(absSum < ans){
//                             ans = absSum;
//                             goodTuple = true;
//                         }
//                     }
//                 }
//             }
//         }
//         if(goodTuple == true) return ans;
//         return -1;
//     }
// }