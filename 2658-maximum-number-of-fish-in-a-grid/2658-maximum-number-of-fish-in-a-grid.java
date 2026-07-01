class Solution {

    int n, m;
    boolean[][] visit;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    public int findMaxFish(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        visit = new boolean[n][m];
        int maxx = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0 && !visit[i][j]){
                    maxx = Math.max(maxx, dfs(i, j, grid));
                }
            }
        }
        return maxx;
    }

    public int dfs(int row, int col, int[][] grid){
        visit[row][col] = true;
        int sum = grid[row][col];

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visit[newr][newc] && grid[newr][newc] != 0){
                sum += dfs(newr, newc, grid);
            }
        }
        return sum;
    }
}