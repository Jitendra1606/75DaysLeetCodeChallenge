//our ans depends on the pos of 1, cnt no. of 0's b/w to 1's
class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {

        long mod = 1_000_000_007;

        long ans = 1;
        int prev = -1;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1){
                if(prev != -1){
                    ans = (ans * (i - prev)) % mod; //multiply the ans
                }

                prev = i; //update the index of 1
            }
        } 
        return prev == -1 ? 0 : (int)ans;
    }
}