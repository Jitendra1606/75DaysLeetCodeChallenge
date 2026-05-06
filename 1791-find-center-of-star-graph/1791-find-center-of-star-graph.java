class Solution {
    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];
        int u1 = edges[1][0];
        int v1 = edges[1][1];
        if(u == u1 || u1 == v) return u1;
        if(u == v1 || v == v1) return v1;
        return -1;
    }
}