class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        int time = 0;
        int cnt = 0;

        while (!q.isEmpty()) {

            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tim;
            q.poll();

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {

                int newr = drow[i] + r;
                int newc = dcol[i] + c;
                //checking all 4 possibilities
                if (newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && grid[newr][newc] == 1) {

                    q.offer(new Tuple(newr, newc, t + 1)); //adjacent 1's are pushed in
                    visited[newr][newc] = true;//the queue simultaneously at the same time
                    cnt++;
                }
            }
        }
        if (cntFresh != cnt)
            return -1; //means all oranges doesn't become rotten
        return time;
    }
}

class Tuple {
    int row;
    int col;
    int tim;

    Tuple(int r, int c, int t) {
        row = r;
        col = c;
        tim = t;
    }
}