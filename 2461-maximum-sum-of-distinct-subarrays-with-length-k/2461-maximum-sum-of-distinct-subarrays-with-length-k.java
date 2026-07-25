class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int i = 0;
        long ans = 0;
        long sum = 0;

        for(int j = 0 ; j < n ; j++){

            while(set.contains(nums[j])){
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            sum += nums[j];
            set.add(nums[j]);

            while(j - i + 1 > k){
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            if(j - i + 1 == k){
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}