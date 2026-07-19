class Solution {
    final static int MOD = (int)(1e9 + 7);
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long cnt1 = 0;
        long cnt2 = 0;
        long res = 0;

        for(int num : nums){
            if(num < a){
                res += (cnt1 + cnt2) % MOD;
            }
            else if(num >= a && num <= b){
                res += (cnt2) % MOD;
                cnt1++;
            }
            else{
                cnt2++;
            }
        }
        return (int)(res % MOD);
    }
}