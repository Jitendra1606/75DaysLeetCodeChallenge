class Solution{
    public int maxProfit(int[] prices){
        int i = 0, j = 1;
        int max = 0;
        int min = prices[0];
        while(j < prices.length){
            if(prices[j] < prices[i]){
                min = prices[j];
                i = j;
            }else{//prices[j] > prices[i]
                max = Math.max(max, prices[j] - prices[i]);
            }
            j++;
        }
        return max;
    }
}





















// class Solution{
//     public int maxProfit(int[] prices){
//         int min = Integer.MAX_VALUE;
//         int maxprofit = 0;
//         for(int i = 0 ; i < prices.length ; i++){
//             if(min > prices[i]){
//                 min = prices[i];
//             }
//             else{
//                 maxprofit = Math.max(maxprofit , prices[i] - min);
//             }
//         }
//         return maxprofit;
//     }
// }


// class Solution {
//     public int maxProfit(int[] prices) {
//         int min = prices[0];
//         int maxprofit = 0;
//         int n = prices.length;
//         for(int i = 1 ; i < n ; i++){
//             int cost = prices[i] - min;
//             maxprofit = Math.max(maxprofit , cost);
//             min = Math.min(min , prices[i]);
//         }
//         return maxprofit;
//     }
// }



// class Solution{
//     public int maxProfit(int[] prices){
//         int n = prices.length;
//         int max = 0;
//         int min = prices[0];
//         for(int i = 1 ; i < n ; i++){
//             int cost = prices[i] - min;
//             max = Math.max(cost , max);
//             min = Math.min(min , prices[i]);
//         }
//         return max;
//     }
// }




