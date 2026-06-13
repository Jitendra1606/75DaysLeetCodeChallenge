class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        
        List<int[]> res = new ArrayList<>();
        //case 1: no overlapping before merging
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //case 2: overlapping and merrging intervals
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        //case 3: no overlapping after merging newInterval
        while(i < n){
            res.add(intervals[i]);
            i++;
        }

        //convert list to array
        return res.toArray(new int[res.size()][]);
    }
}