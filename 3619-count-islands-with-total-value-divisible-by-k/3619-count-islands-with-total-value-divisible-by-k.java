class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] != 0) {
                    long sum = dfs(i, j, grid, visit);

                    if (sum % k == 0)
                        islands++;
                }
            }
        }
        return islands;
    }

    public long dfs(int i, int j, int[][] grid, boolean[][] visit) {
        int n = grid.length;
        int m = grid[0].length;
        
        visit[i][j] = true;

        long sum = grid[i][j];

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int newr = drow[k] + i;
            int newc = dcol[k] + j;

            if (newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] != 0 && !visit[newr][newc]) {
                sum += dfs(newr, newc, grid, visit);
            }
        }

        return sum;
    }
}

// class Solution {
//     int n, m;
//     boolean[][] visit;
//     int[] drow = {-1, 0, 1, 0};
//     int[] dcol = {0, 1, 0, -1};
//     public int countIslands(int[][] grid, int k) {
//         n = grid.length;
//         m = grid[0].length;

//         visit = new boolean[n][m];
//         int islands = 0;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 if(!visit[i][j] && grid[i][j] != 0){
//                     long sum = dfs(i, j, grid);

//                     if(sum % k == 0) islands++;
//                 }
//             }
//         }
//         return islands;
//     }

//     public long dfs(int row, int col, int[][] grid){
//         visit[row][col] = true;

//         long sum = grid[row][col];

//         for(int i = 0 ; i < 4 ; i++){
//             int newr = drow[i] + row;
//             int newc = dcol[i] + col;

//             if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visit[newr][newc] && grid[newr][newc] != 0){
//                 sum += dfs(newr, newc, grid);
//             }
//         }
//         return sum;
//     }
// }