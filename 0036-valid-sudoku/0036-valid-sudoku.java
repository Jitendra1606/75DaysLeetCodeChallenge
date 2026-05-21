class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0 ; i < 9 ; i++) {

            for(int j = 0 ; j < 9 ; j++) {

                if(board[i][j] != '.') {

                    char d = board[i][j];

                    // temporarily remove current number
                    board[i][j] = '.';

                    if(!isValid(board, i, j, d)) {
                        return false;
                    }

                    // put it back
                    board[i][j] = d;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char d) {

        for(int i = 0 ; i < 9 ; i++) {

            // check column
            if(board[i][col] == d) return false;

            // check row
            if(board[row][i] == d) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int k = 0 ; k < 3 ; k++) {

            for(int l = 0 ; l < 3 ; l++) {

                if(board[startRow + k][startCol + l] == d)
                    return false;
            }
        }

        return true;
    }
}