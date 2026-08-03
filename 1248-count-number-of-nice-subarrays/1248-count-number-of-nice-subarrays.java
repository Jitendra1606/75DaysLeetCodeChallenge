//this is sliding window -> (Atmost k - less than k = exact k)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int x) {
        int n = nums.length;

        int left = 0, cntOdd = 0, ans = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1)
                cntOdd++;

            while (cntOdd > x) {
                if (nums[left] % 2 == 1)
                    cntOdd--;
                left++;
            }

            ans += (right - left + 1); //this gives all the possible subarrays
        }

        return ans;

    }
}

//this approach is based on prefix sum + hashMap
// class Solution{
//     public int numberOfSubarrays(int[] nums, int k){
//         int n = nums.length;

//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);

//         int cntOdd = 0, ans = 0;

//         for(int num : nums){

//             if(num % 2 == 1) cntOdd++;

//             if(map.containsKey(cntOdd - k)){
//                 ans += map.get(cntOdd - k);
//             }

//             map.put(cntOdd, map.getOrDefault(cntOdd, 0) + 1);
//         }

//         return ans;
//     }
// }