class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = 1;

        for(int i = 0 ; i < n ; i++){  //row wise traversal kr rhe h ham
            boolean[] visited = new boolean[n]; //hr baar nyi possibility ho skti h
            max = Math.max(max, dfs(i, visited, bombs));
        }
        return max;
    }
//hm logo ko x, y se kch lena dena nhi h sirf row wise bombs ko check krte chl rhe h
    public int dfs(int curr, boolean[] visited, int[][] bombs){
        visited[curr] = true;
        int cnt = 1;

        for(int next = 0 ; next < bombs.length ; next++){ //ab aage baaki ki rows check kr rhe
            if(!visited[next] && canDetonate(curr, next, bombs)) {
                cnt += dfs(next, visited, bombs);
            }//ki is bomb se aage kitne bomb aur detonate ho skte h, unka cnt krlo,
        } //aur ese hi hr bomb se check krlo ki kisse kitne possible h aur max bta do bs
        return cnt;
    }

    public boolean canDetonate(int i, int j, int[][] bombs){

        long x1 = bombs[i][0];
        long y1 = bombs[i][1];
        long r = bombs[i][2];

        long x2 = bombs[j][0];
        long y2 = bombs[j][1];

        long dx = x1 - x2;
        long dy = y1 - y2;

        return dx * dx + dy * dy <= r * r;
    }
}