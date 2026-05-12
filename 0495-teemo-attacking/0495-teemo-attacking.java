class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int cnt = 0, n = timeSeries.length;
        for(int i = 0 ; i < n - 1 ; i++){
            // if next attack occurs before current duration ends, include the difference
            if(timeSeries[i + 1] <= timeSeries[i] + duration - 1){
                cnt += timeSeries[i + 1] - timeSeries[i];
            }
            else{
                cnt += duration;
            }
        }
        cnt += duration;
        return cnt;
    }
}