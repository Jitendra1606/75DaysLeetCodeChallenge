class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;

        double sum = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = n - 1, j = m - 1;

        while(i >= 0 && j >= 0){
            sum += (double)(((double)prices[i] * (100 - (double)discounts[j])) / 100);
            i--;
            j--;
        }

        while(i >= 0){
            sum += prices[i];
            i--;
        }

        return sum;
    }
}