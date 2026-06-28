class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];

        for(int[] book : bookings){
            int start = book[0];
            int end = book[1];

            diff[start] += book[2];
            if(end < n) diff[end + 1] -= book[2];
        }

        //prefix sum
        for(int i = 1 ; i <= n ; i++){
            diff[i] = diff[i - 1] + diff[i];
        }

        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = diff[i + 1];
        }

        return ans;
    }
}