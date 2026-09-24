class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(isdig(nums[i], i)) return i;
        }
        return -1;
    }

    public boolean isdig(int dig, int tar){
        int sum = 0;

        while(dig != 0){
            int rem = dig % 10;
            sum += rem;
            dig /= 10;
        }

        return sum == tar;
    }
}