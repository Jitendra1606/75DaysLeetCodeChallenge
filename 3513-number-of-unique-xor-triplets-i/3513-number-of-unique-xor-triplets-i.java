class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int msb = (int)(Math.log(n) / Math.log(2));
        int pow = (int)(Math.pow(2, msb + 1)) - 1;

        return pow + 1;
    }
}