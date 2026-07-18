class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int gc = 0;
            for(int j = i ; j < n ; j++){
                gc = gcd(gc, nums[j]);

                if(gc == k) cnt++;
            }
        }
        return cnt;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}