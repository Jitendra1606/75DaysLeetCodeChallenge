//since we can minimize the time by travelling through diagonals only and we only need to know if this mintime < given time(t), only fails for 1 bcz we can't reach the given cell with one move from that, and if mintime > time and diff > 1 then we can always reach that cell

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);

        // Same starting and ending cell
        // cannot be reached in exactly 1 second
        if(width == 0 && height == 0 && t == 1) return false;

        return t >= Math.max(width, height);
    }
}