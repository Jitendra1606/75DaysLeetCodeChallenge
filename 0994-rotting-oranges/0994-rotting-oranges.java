class Tuple{
    int row;
    int col;
    int tm;

    Tuple(int r, int c, int t){
        row = r;
        col = c;
        tm = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int cntFresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.offer(new Tuple(i, j, 0));
                    visited[i][j] = true;
                } 
                if(grid[i][j] == 1) cntFresh++;
            }
        }       
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.poll();
            tm = Math.max(tm, t);
            for(int i = 0; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    q.offer(new Tuple(nrow, ncol, t + 1));
                    visited[nrow][ncol] = true;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;
    }
}