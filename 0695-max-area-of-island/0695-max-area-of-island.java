class Solution{
    boolean[][] visited;
    int n, m;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid){
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    public int dfs(int row, int col, int[][] grid){
        visited[row][col] = true;
        int cnt = 1;

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr < n && newc < m && newr >= 0 && newc >= 0 && !visited[newr][newc] && grid[newr][newc] == 1){
                cnt += dfs(newr, newc, grid);
            }
        }
        return cnt;
    }
}





































// class Solution {
//     boolean[][] visited;
//     int m, n;
//     int[] dRow = {-1, 0, 1, 0};
//     int[] dCol = {0, 1, 0, -1};

//     public int maxAreaOfIsland(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         visited = new boolean[m][n];
//         int maxArea = 0;

//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(grid[i][j] == 1 && !visited[i][j]){
//                     maxArea = Math.max(maxArea, dfs(i, j, grid));
//                 }
//             }
//         }    
//         return maxArea;
//     }
//     public int dfs(int r, int c, int[][] grid){
//         visited[r][c] = true;
//         int area = 1;
//         for(int i = 0 ; i < 4 ; i++){
//             int nRow = r + dRow[i];
//             int nCol = c + dCol[i];

//             if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1){
//                 area += dfs(nRow, nCol, grid);
//             }
//         }
//         return area;
//     }
// }