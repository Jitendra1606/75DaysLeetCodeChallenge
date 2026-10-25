class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visit[i][j] && bfs(i, j, n, m, grid, visit))
                    cnt++;
            }
        }

        return cnt;
    }

    public boolean bfs(int x, int y, int n, int m, int[][] grid, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visit[x][y] = true;
        boolean isclose = true;

        int[] dirx = { -1, 0, 1, 0 };
        int[] diry = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int r = x + dirx[i];
                int c = y + diry[i];

                if (r < 0 || c < 0 || r >= n || c >= m)
                    isclose = false;

                else if (grid[r][c] == 0 && !visit[r][c]) {
                    q.offer(new int[] { r, c });
                    visit[r][c] = true;
                }
            }
        }
        return isclose;
    }
}