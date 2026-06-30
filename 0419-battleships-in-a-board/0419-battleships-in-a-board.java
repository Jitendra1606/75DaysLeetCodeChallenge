class Solution{
    public int countBattleships(char[][] board){
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        int ships = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    ships++;
                    dfs(i, j, board, visited);
                }
            }
        }
        return ships;
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited){
        visited[row][col] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr < board.length && newc < board[0].length && newr >= 0 && newc >= 0 && !visited[newr][newc] && board[newr][newc] == 'X') 
            dfs(newr, newc, board, visited);
        }
    }
}
































// class Solution {
//     public int countBattleships(char[][] board) {
//         int n = board.length;
//         int m = board[0].length;
//         int cnt = 0;

//         boolean[][] visited = new boolean[n][m];

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 if(board[i][j] == 'X' && !visited[i][j]){
//                     cnt++;

//                     dfs(i, j, visited, board);
//                 }
//             }
//         }
//         return cnt;
//     }

//     public void dfs(int r, int c, boolean[][] visited, char[][] board){
//         visited[r][c] = true;

//         int[] drow = {-1, 0, 1, 0};
//         int[] dcol = {0, 1, 0, -1};

//         for(int i = 0 ; i < 4 ; i++){
//             int newr = drow[i] + r;
//             int newc = dcol[i] + c;

//             if(newr >= 0 && newr < board.length && newc >= 0 && newc < board[0].length && !visited[newr][newc] && board[newr][newc] == 'X') dfs(newr, newc, visited, board);
//         }
//     }
// }





// class Solution{
//     public int countBattleships(char[][] board){
//         int n = board.length;
//         int m = board[0].length;

//         boolean[][] visited = new boolean[n][m];
//         int cnt = 0;

//         int[] drow = {-1, 0, 1, 0};
//         int[] dcol = {0, 1, 0, -1};

//         for(int i = 0 ; i < n ; i++){

//             for(int j = 0 ; j < m ; j++){

//                 if(board[i][j] == 'X' && !visited[i][j]){
//                     cnt++;

//                     Queue<int[]> q = new LinkedList<>();

//                     q.offer(new int[]{i, j});
//                     visited[i][j] = true;

//                     while(!q.isEmpty()){
//                         int[] curr = q.poll();

//                         int r = curr[0];
//                         int c = curr[1];

//                         for(int k = 0 ; k < 4 ; k++){

//                             int newr = r + drow[k];
//                             int newc = c + dcol[k];

//                             if(newr >= 0 && newc >= 0 && newr < n && newc < m && board[newr][newc] == 'X' && !visited[newr][newc]){
//                                 q.offer(new int[]{newr, newc});
//                                 visited[newr][newc] = true;
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return cnt;
//     } 
// }