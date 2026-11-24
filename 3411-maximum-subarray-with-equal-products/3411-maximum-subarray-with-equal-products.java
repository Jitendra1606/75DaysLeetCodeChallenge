class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int prod = 1, gcds = nums[i], lcms = nums[i];
            for (int j = i; j < n; j++) {
                prod *= nums[j];

                gcds = gcd(gcds, nums[j]);
                lcms = lcm(lcms, nums[j]);

                if (prod == gcds * lcms)
                    cnt = Math.max(cnt, j - i + 1);
            }
        }

        return cnt;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}