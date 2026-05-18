class Solution {
    public boolean predictTheWinner(int[] nums) {
        int ans = solve(nums, 0, nums.length - 1);

        return ans >= 0;
    }

    public int solve(int[] nums, int i, int j){
        if(i == j) return nums[i]; //when only one element left

        //choosing left
        int left = nums[i] - solve(nums, i + 1, j);

        //choosing right
        int right = nums[j] - solve(nums, i, j - 1);

        return Math.max(left, right);
    }
}

//Because the recursion returns: that's why for +ve ans A is winning
// (current player score) - (other player score) (NOT the actual score.)