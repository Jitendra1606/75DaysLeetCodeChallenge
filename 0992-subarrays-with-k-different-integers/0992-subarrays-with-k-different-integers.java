class Solution{
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int x){

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, n = nums.length, sum = 0;

        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > x){
                map.put(nums[left], map.get(nums[left]) - 1);

                if(map.get(nums[left]) == 0) 
                map.remove(nums[left]);

                left++;
            }

            sum += (right - left + 1); 

            right++;
        }
        return sum;
    }
}



// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         if(k < 0) return 0;
//         return solve(nums, k) - solve(nums, k - 1);
//     }

//     public int solve(int[] nums, int k){
//         int n = nums.length;

//         HashMap<Integer, Integer> map = new HashMap<>();
//         int left = 0, right = 0, sum = 0;

//         while(right < n){

//             map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

//             while(map.size() > k){

//                 map.put(nums[left], map.get(nums[left]) - 1);

//                 if(map.get(nums[left]) == 0){
//                     map.remove(nums[left]);
//                 }

//                 left++;
//             }

//             sum += (right - left + 1);

//             right++;
//         }

//         return sum;
//     }
// }