class Solution {
    int n, m;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    boolean[][] visited;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;

        visited = new boolean[n][m];

        int subIslands = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid2[i][j] == 1){
                    if(dfs(i, j, grid1, grid2))
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    public boolean dfs(int row, int col, int[][] grid1, int[][] grid2){
        visited[row][col] = true;

        // Current cell is valid only if grid1 also has land here
        boolean issubIsland = (grid1[row][col] == 1);

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && grid2[newr][newc] == 1){
                issubIsland &= dfs(newr, newc, grid1, grid2);
            }
        }
        return issubIsland;
    }
}


// Why do we use
// isSubIsland &= dfs(newr, newc, grid1, grid2);

// instead of

// isSubIsland = isSubIsland && dfs(...);

// Both give the same final boolean result, but &= does not short-circuit. That means even if isSubIsland is already false, it still calls dfs() on the neighbor.

// This is important because we must visit the entire island to mark all its cells as visited. If we used && and isSubIsland became false early, the remaining DFS calls would be skipped, leaving part of the island unvisited and causing incorrect counting later.