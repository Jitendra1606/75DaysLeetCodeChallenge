class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];

        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && mat[i][j] == 0) {
                    q.offer(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tim;
            q.poll();

            ans[r][c] = t;

            for(int i = 0 ; i < 4 ; i++){
                int newr = drow[i] + r;
                int newc = dcol[i] + c;

                if(newr >= 0 && newc >= 0 && newr < n && newc < m && mat[newr][newc] == 1 && !visited[newr][newc]){
                    q.offer(new Tuple(newr, newc, t + 1));
                    visited[newr][newc] = true;
                }
            }
        }
        return ans;
    }
}

class Tuple {
    int row;
    int col;
    int tim;

    Tuple(int row, int col, int tim) {
        this.row = row;
        this.col = col;
        this.tim = tim;
    }
}