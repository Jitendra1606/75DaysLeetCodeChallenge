class Solution{

    int n, m;
    boolean[][] visit;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    public void solve(char[][] board){

        n = board.length;
        m = board[0].length;

        visit = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(!visit[i][j] && board[i][j] == 'O'){
                        dfs(i, j, board);
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visit[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board){
        visit[row][col] = true;

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visit[newr][newc] && board[newr][newc] == 'O') dfs(newr, newc, board);
        }
    }
}