class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j]){
                    if(bfs(i, j, grid, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int i, int j, char[][] grid, boolean[][] visited){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j, -1, -1));
        visited[i][j] = true;

        while(!q.isEmpty()){
            Pair it = q.poll();
            int r = it.r;
            int c = it.c;

            for(int k = 0 ; k < 4 ; k++){
                int newr = r + drow[k];
                int newc = c + dcol[k];
                
                if(newr >= 0 && newc >= 0 && newr < grid.length && newc < grid[0].length && grid[newr][newc] == grid[r][c]){
                    if(!visited[newr][newc]){
                        visited[newr][newc] = true;
                        q.offer(new Pair(newr, newc, r, c));
                    }
                    else if(newr != it.rc || newc != it.cc){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Pair{
    int r;
    int c;
    int rc; //parent row
    int cc; //parent col

    Pair(int r, int c, int rc, int cc){
        this.r = r;
        this.c = c;
        this.rc = rc;
        this.cc = cc;
    }
}