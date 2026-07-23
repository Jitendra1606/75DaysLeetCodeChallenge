class Solution{
    final static int MOD = (int)(1e9 + 7);
    public int maxProfit(int[] inventory, int orders){
        int n = inventory.length;

        Arrays.sort(inventory);

        //reverse to decreasing order
        for(int i = 0 , j = n - 1 ; i < j ; i++, j--){
            int temp = inventory[i];
            inventory[i] = inventory[j];
            inventory[j] = temp;
        }

        int low = 0, high = inventory[0];
        int k = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(mid, inventory, orders)){
                k = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        long sum = 0;
        for(int i = 0 ; i < inventory.length ; i++){
            int balls = inventory[i];

            if(balls > k){
                orders -= (balls - k);
                inventory[i] = k;

                long s = (balls * 1L * (balls + 1)) / 2 - (k * 1L * (k + 1)) / 2;

                sum = (sum + s) % MOD;
            }

            if(orders == 0){
                break;
            }
        }

        sum = (sum + k * 1L * orders) % MOD;

        return (int)sum;
    }

    public boolean check(int k, int[] inventory, int orders){
        long cnt = 0;
        int c = 0;

        for(int i : inventory){
            if(i > k){
                cnt += (i - k);
            }

            if(i >= k){
                c++;
            }

            if(cnt + c >= orders){
                return true;
            }
        }
        return cnt + c >= orders;
    }
}




// class Solution {
//     final static int MOD = (int)(1e9 + 7);
//     public int maxProfit(int[] inventory, int orders) {
//         int n = inventory.length;

//         PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for(int i = 0 ; i < n ; i++){
//             pq.offer((long)inventory[i]);
//         }

//         long cnt = 0;
//         for(int i = 0 ; i < orders ; i++){
//             cnt += pq.peek();

//             long value = (pq.poll() - 1) % MOD;
//             pq.offer(value % MOD);
//         }

//         return (int)(cnt % MOD);
//     }
// }