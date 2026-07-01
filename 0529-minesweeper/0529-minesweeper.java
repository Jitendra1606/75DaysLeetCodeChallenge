class Solution {
    
    int n, m;
    int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
    
        n = board.length;
        m = board[0].length;

        int row = click[0];
        int col = click[1];

        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }

        dfs(row, col, board);
        return board;
    }

    public void dfs(int row, int col, char[][] board){

        //already revealed
        if(board[row][col] != 'E') return;

        int mines = 0;

        //cnt adjacent mines
        for(int i = 0 ; i < 8 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && board[newr][newc] == 'M') mines++;
        }

        //if adjacent mines exist, place digit and stop
        if(mines > 0){
            board[row][col] = (char)(mines + '0');
            return;
        }

        //no adjacent mines
        board[row][col] = 'B';

        //Reveal neighbors
        for(int i = 0 ; i < 8 ; i++){
            int newr = row + drow[i];
            int newc = col + dcol[i];

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && board[newr][newc] == 'E') dfs(newr, newc, board);
        }
    }
}