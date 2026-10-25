class Solution{
    public int closedIsland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    dfs(grid, i, j, visit);
                }
            }
        }

        int cnt = 0;

        for(int i = 1 ; i < n - 1 ; i++){
            for(int j = 1 ; j < m - 1 ; j++){
                if(grid[i][j] == 0 && !visit[i][j]){
                    dfs(grid, i, j, visit);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visit){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || visit[i][j] || grid[i][j] == 1) return;

        visit[i][j] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int x = 0 ; x < 4 ; x++){
            int newr = drow[x] + i;
            int newc = dcol[x] + j;

            dfs(grid, newr, newc, visit);
        }
    }
}


// class Solution {
//     public int closedIsland(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;

//         boolean[][] visit = new boolean[n][m];
//         int cnt = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 0 && !visit[i][j] && bfs(i, j, n, m, grid, visit))
//                     cnt++;
//             }
//         }

//         return cnt;
//     }

//     public boolean bfs(int x, int y, int n, int m, int[][] grid, boolean[][] visit) {
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] { x, y });
//         visit[x][y] = true;
//         boolean isclose = true;

//         int[] dirx = { -1, 0, 1, 0 };
//         int[] diry = { 0, 1, 0, -1 };

//         while (!q.isEmpty()) {
//             int[] temp = q.poll();
//             x = temp[0];
//             y = temp[1];

//             for (int i = 0; i < 4; i++) {
//                 int r = x + dirx[i];
//                 int c = y + diry[i];

//                 if (r < 0 || c < 0 || r >= n || c >= m)
//                     isclose = false;

//                 else if (grid[r][c] == 0 && !visit[r][c]) {
//                     q.offer(new int[] { r, c });
//                     visit[r][c] = true;
//                 }
//             }
//         }
//         return isclose;
//     }
// }