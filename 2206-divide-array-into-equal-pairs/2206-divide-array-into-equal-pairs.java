class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int[] hash = new int[501];

        for(int i = 0 ; i < n ; i++){
            hash[nums[i]]++;
        }

        for(int i = 1 ; i < 501 ; i++){
            if(hash[i] % 2 == 1) return false;
        }
        return true;
    }
}