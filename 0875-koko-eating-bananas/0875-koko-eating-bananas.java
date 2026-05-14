class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = max(piles);
        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            long cnthrs = isPossible(piles, mid);

            if(cnthrs <= h){
                // ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low; //instead of ans
    }

    //to check if our assumed value is correct or not
    public long isPossible(int[] piles, int mid){
        long n = piles.length, sum = 0;

        for(int i = 0 ; i < n ; i++){
            sum += (piles[i] + mid - 1) / mid;
        }
        return sum;
    }

    //to find the value of maximum pile in the piles
    public int max(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length ; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}