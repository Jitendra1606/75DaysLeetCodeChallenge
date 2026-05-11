//t.c = O(n), s.c = O(1)
class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
        int min = prices[0];
        int profit = 0, cost = 0;
        for(int i = 1 ; i < n ; i++){
            cost = prices[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}


//all the solutions below are of two pointers approach
// class Solution{
//     public int maxProfit(int[] prices){
//         int i = 0, j = 1;
//         int max = 0;
//         int min = prices[0];
//         while(j < prices.length){
//             if(prices[j] < prices[i]){
//                 min = prices[j];
//                 i = j;
//             }else{//prices[j] > prices[i]
//                 max = Math.max(max, prices[j] - prices[i]);
//             }
//             j++;
//         }
//         return max;
//     }
// }
