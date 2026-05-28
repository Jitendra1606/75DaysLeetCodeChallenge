class Solution {
    boolean[][] visited;
    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int islands = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int r, int c, char[][] grid){
        visited[r][c] = true;
        //simple dfs like previous questions(rooten orange, flood fill)
        for(int i = 0 ; i < 4 ; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            if(nRow >= 0 && nCol >= 0 && nCol < n && nRow < m && !visited[nRow][nCol] && grid[nRow][nCol] == '1')
            dfs(nRow, nCol, grid);
        }
    }
}