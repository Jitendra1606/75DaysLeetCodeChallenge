class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int cnt = 0;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    cnt++;

                    dfs(i, j, visited, board);
                }
            }
        }
        return cnt;
    }

    public void dfs(int r, int c, boolean[][] visited, char[][] board){
        visited[r][c] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + r;
            int newc = dcol[i] + c;

            if(newr >= 0 && newr < board.length && newc >= 0 && newc < board[0].length && !visited[newr][newc] && board[newr][newc] == 'X') dfs(newr, newc, visited, board);
        }
    }
}