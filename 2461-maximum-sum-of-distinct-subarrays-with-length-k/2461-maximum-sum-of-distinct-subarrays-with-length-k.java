class Solution{
    public long maximumSubarraySum(int[] nums, int k){
        int n = nums.length;
        long ans = 0, sum = 0;

        Set<Integer> set = new HashSet<>();

        int left = 0, right = 0;

        while(right < n){

            while(set.contains(nums[right])){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            sum += nums[right];

            set.add(nums[right]);

            while(right - left + 1 > k){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            if(right - left + 1 == k){
                ans = Math.max(ans, sum);
            }
            
            right++;
        }
        return ans;
    }
}














// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         int n = nums.length;
//         Set<Integer> set = new HashSet<>();

//         int i = 0;
//         long ans = 0;
//         long sum = 0;

//         for(int j = 0 ; j < n ; j++){

//             while(set.contains(nums[j])){
//                 sum -= nums[i];
//                 set.remove(nums[i]);
//                 i++;
//             }

//             sum += nums[j];
//             set.add(nums[j]);

//             while(j - i + 1 > k){
//                 sum -= nums[i];
//                 set.remove(nums[i]);
//                 i++;
//             }

//             if(j - i + 1 == k){
//                 ans = Math.max(ans, sum);
//             }
//         }
//         return ans;
//     }
// }