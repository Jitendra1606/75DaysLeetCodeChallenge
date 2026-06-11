class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for(int num : nums){
            curMax = Math.max(num, curMax + num); //simple kadane's
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        if(maxSum > 0){
            return Math.max(maxSum, total - minSum);
        }
        return maxSum;//in case all values are negative then we need to return maximum sum to handle this case
    }
}
//otherwise (total - minSum) is the answer to this question
//t.c = O(n)
//s.c = O(1)