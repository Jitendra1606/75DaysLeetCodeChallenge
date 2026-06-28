class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = Integer.MIN_VALUE;
        int n = trips.length;
        for(int i = 0 ; i < trips.length ; i++){
            if(trips[i][2] > max) max = trips[i][2];
        }
        int[] diff = new int[max + 1];

        for(int[] trip : trips){
            int start = trip[1];
            int end = trip[2];

            diff[start] += trip[0];
            diff[end] -= trip[0];
        }

        for(int i = 1 ; i < max ; i++){
            diff[i] = diff[i] + diff[i - 1];
        }

        for(int i = 0 ; i < max ; i++){
            if(diff[i] > capacity) return false;
        }
        return true;
    }
}