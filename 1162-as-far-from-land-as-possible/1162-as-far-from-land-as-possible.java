//multi source bfs
class Solution {
    int n;
    boolean[][] visited;

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    public int maxDistance(int[][] grid) {

        n = grid.length;
        visited = new boolean[n][n];

        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    q.add(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        //all water or all land cases
        if (q.size() == 0 || q.size() == n * n)
            return -1;

        int result = 0;

        while (!q.isEmpty()) {

            int curRow = q.peek().row;
            int curCol = q.peek().col;
            int curTim = q.peek().tim;
            q.poll();

            result = curTim;

            for (int i = 0; i < 4; i++) {
                int newr = drow[i] + curRow;
                int newc = dcol[i] + curCol;

                if (newr >= 0 && newc >= 0 && newr < n && newc < n && !visited[newr][newc]) {
                    q.offer(new Tuple(newr, newc, curTim + 1));
                    visited[newr][newc] = true;
                }
            }
        }
        return result;
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