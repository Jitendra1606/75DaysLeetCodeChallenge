class Solution {
    int n, m;
    boolean[][] visited;

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(i, j, grid));
                    // ans = Math.max(ans, dfs(i, j, grid));
                }
            }
        }
        return ans;
    }

    public int bfs(int i, int j, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        
        visited[i][j] = true;
        
        int area = 1;

        while(!q.isEmpty()){
            int[] mat = q.poll();

            int r = mat[0];
            int c = mat[1];

            for(int k = 0 ; k < 4 ; k++){
                int newr = r + drow[k];
                int newc = c + dcol[k];

                if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && grid[newr][newc] == 1){

                    visited[newr][newc] = true;
                    area++;
                    q.offer(new int[]{newr, newc});
                }
            }
        }
        return area;
    }

    public int dfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        int area = 1;

        for (int k = 0; k < 4; k++) {
            int newr = drow[k] + i;
            int newc = dcol[k] + j;

            if (newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && grid[newr][newc] == 1) {
                area += dfs(newr, newc, grid);
            }
        }
        return area;
    }
}

// //bfs
// class Solution{
//     boolean[][] visited;
//     int n, m;
//     int[] drow = {-1, 0, 1, 0};
//     int[] dcol = {0, 1, 0, -1};
//     public int maxAreaOfIsland(int[][] grid){
//         n = grid.length;
//         m = grid[0].length;

//         visited = new boolean[n][m];
//         int max = 0;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 if(grid[i][j] == 1 && !visited[i][j]){
//                     max = Math.max(max, bfs(i, j, grid));
//                 }
//             }
//         }
//         return max;
//     }

//     public int bfs(int row, int col, int[][] grid){
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{row, col});
//         visited[row][col] = true;

//         int area = 1;
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];

//             for(int i = 0 ; i < 4 ; i++){
//                 int newr = drow[i] + r;
//                 int newc = dcol[i] + c;

//                 if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && grid[newr][newc] == 1){
//                     visited[newr][newc] = true;
//                     area++;
//                     q.offer(new int[]{newr, newc});
//                 }
//             }
//         }
//         return area;
//     }
// }

// //dfs
// // class Solution{
// //     boolean[][] visited;
// //     int n, m;
// //     int[] drow = {-1, 0, 1, 0};
// //     int[] dcol = {0, 1, 0, -1};
// //     public int maxAreaOfIsland(int[][] grid){
// //         n = grid.length;
// //         m = grid[0].length;

// //         visited = new boolean[n][m];
// //         int max = 0;

// //         for(int i = 0 ; i < n ; i++){
// //             for(int j = 0 ; j < m ; j++){
// //                 if(grid[i][j] == 1 && !visited[i][j]){
// //                     max = Math.max(max, dfs(i, j, grid));
// //                 }
// //             }
// //         }
// //         return max;
// //     }

// //     public int dfs(int row, int col, int[][] grid){
// //         visited[row][col] = true;
// //         int cnt = 1;

// //         for(int i = 0 ; i < 4 ; i++){
// //             int newr = drow[i] + row;
// //             int newc = dcol[i] + col;

// //             if(newr < n && newc < m && newr >= 0 && newc >= 0 && !visited[newr][newc] && grid[newr][newc] == 1){
// //                 cnt += dfs(newr, newc, grid);
// //             }
// //         }
// //         return cnt;
// //     }
// // }