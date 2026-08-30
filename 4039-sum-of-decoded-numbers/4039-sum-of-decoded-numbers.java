class Solution {
    static final int MOD = (int)(1e9 + 7);

    public int sumDecoded(long[] nums) {
        int n = nums.length;

        long ans = 0;

        for(int i = 0 ; i < n ; i++){
            long num = nums[i];

            int ed = (int)(num % 10);

            num /= 10;

            String s = String.valueOf(num);

            long fir = Long.parseLong(s.substring(0, ed));

            long sec = Long.parseLong(s.substring(ed));

            long value = pow(fir, sec);

            ans = (ans + value) % MOD;
        }

        return (int)ans;
    }

    public long pow(long base, long power){
        if(power == 0) return 1;

        if(power % 2 == 0) return pow(base * base % MOD, power / 2) % MOD;

        return base * pow(base * base % MOD, (power - 1) / 2) % MOD;
    }
}