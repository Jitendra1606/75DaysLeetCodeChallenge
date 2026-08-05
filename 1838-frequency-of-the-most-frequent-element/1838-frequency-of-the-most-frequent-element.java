class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);
        int cnt = 0;

        int left = 0, right = 0;
        long sum = 0;

        while(right < n){
            sum += nums[right];

            long req = 1L * nums[right] * (right - left + 1);

            if(req - sum <= k){
                cnt = Math.max(cnt, right - left + 1);
            }else{
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return cnt;
    }
}