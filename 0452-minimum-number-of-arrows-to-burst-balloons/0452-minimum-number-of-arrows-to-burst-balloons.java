class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
//sorting with the ending time, how many cordinates are common?
        int prevEnd = points[0][1];
        int cnt = 1;

        for(int i = 1 ; i < n ; i++){
            if(points[i][0] > prevEnd){
                prevEnd = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}