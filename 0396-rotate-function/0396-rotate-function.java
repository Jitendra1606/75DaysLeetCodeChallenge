//great question on how to simulate or generalize the question when no other topic seems to be applied
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, fun = 0;

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            fun = fun + i * nums[i];
        }

        int result = fun;
        for(int j = 1 ; j < n ; j++){
            int newF = fun + sum - n * nums[n - j];
            result = Math.max(result, newF);
            fun = newF;
        }
        return result;
    }
}