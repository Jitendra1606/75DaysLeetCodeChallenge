class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int tot = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            if(prices[i] < prices[i + 1]){
                tot += (prices[i + 1] - prices[i]);
            }
        }
        return tot;
    }
}