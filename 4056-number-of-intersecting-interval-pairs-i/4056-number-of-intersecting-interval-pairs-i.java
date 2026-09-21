class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int cnt = 0;
        for(int j = 0 ; j < n - 1 ; j++){
            for(int i = j ; i < n - 1 ; i++){
                if(intervals[j][1] == intervals[i + 1][0] || (intervals[j][0] <= intervals[j][1] && intervals[j][1] >= intervals[i + 1][0])) cnt++;
            }
        }
        return cnt;
    }
}