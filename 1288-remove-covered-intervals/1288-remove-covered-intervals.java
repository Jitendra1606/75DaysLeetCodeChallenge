class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1)
            return 1;

        int cnt = 1;

        // When starts are equal, put the bigger ending interval first.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });

        int first = intervals[0][0];
        int second = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (first <= intervals[i][0] && second >= intervals[i][1])
                continue;
            else
                cnt++;
            first = intervals[i][0];
            second = intervals[i][1];
        }
        return cnt;
    }
}