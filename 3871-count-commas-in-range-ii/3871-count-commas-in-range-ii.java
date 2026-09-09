class Solution {
    public long countCommas(long n) {
        long dig = String.valueOf(n).length();
        
        long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
        if (dig <= 3)
            return 0;
        if (dig >= 4 && dig <= 6) {
            sum1 = (n - 999);
            return sum1;
        } else if (dig >= 7 && dig <= 9) {
            sum1 = 999000;
            sum2 = sum1 + 2 * (n - 999999);
            return sum2;
        } else if (dig >= 10 && dig <= 12) {
            sum1 = 999000;
            sum2 = sum1 + 2 * (999999999 - 999999);
            sum3 = sum2 + 3 * (n - 999999999L);
            return sum3;
        } else if (dig >= 13 && dig <= 15) {
            sum1 = 999000;
            sum2 = sum1 + 2 * (999999999 - 999999);
            sum3 = sum2 + 3 * (999999999999L - 999999999L);
            return sum3 + 4 * (n - 999999999999L);
        }
        sum1 = 999000;
        sum2 = sum1 + 2 * (999999999 - 999999);
        sum3 = sum2 + 3 * (999999999999L - 999999999L);
        sum4 = sum3 + 4 * (999999999999999L - 999999999999L);
        sum5 = sum4 + 5 * (n - 999999999999999L);
        return sum5;
    }
}