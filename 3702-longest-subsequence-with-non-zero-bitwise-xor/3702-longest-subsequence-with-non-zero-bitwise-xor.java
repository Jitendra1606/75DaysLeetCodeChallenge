class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean ok = false;
        int xor = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                ok = true;
            }
            xor ^= nums[i];
        }

        if(!ok) return 0;

        if(xor != 0) return n;
        return n - 1;
    }
}