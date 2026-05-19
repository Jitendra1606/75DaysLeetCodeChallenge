//in this approach we can't reduce complexity much we need to traverse in all rows and then in each column but we can reduce complexity in isvalid function  

class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return result;

        //initially filling the board with .'s
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        //we are storing all the possible wrong places to place so we will not place new queen in that position in the future
        //like for upward we will check if the current column is already in our hashset then how e can use this column
        //and for right diagonal and left diagonal we will use the constant property , bcz the sum of right right diagonal is constant ((1,3),(2,2) -> they all have sum = 4) and for left diagonal the differnce is constant ((3,2),(2,1) -> differnce is same) 

        int startRow = 0;
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diags = new HashSet<>();
        HashSet<Integer> antiDiags = new HashSet<>();

        solve(board, startRow, cols, diags, antiDiags);

        return result;
    }

    public void solve(List<String> board, int row, HashSet<Integer> cols , HashSet<Integer> diags, HashSet<Integer> antiDiags) {

        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }
        
        for(int col = 0 ; col < board.size() ; col++){
            int diagId = row - col; //left diagonal
            int antiDiagId = row + col; //right diagoanl

            if(cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId)) continue;

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);

            StringBuilder newRow = new StringBuilder(board.get(row));

            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solve(board, row + 1, cols, diags, antiDiags);

            //backtrack
            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
}


// class Solution {
//     List<List<String>> result = new ArrayList<>();

//     public List<List<String>> solveNQueens(int n) {
//         if (n == 0)
//             return result;

//         //initially filling the board with .'s
//         List<String> board = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             StringBuilder sb = new StringBuilder();

//             for (int j = 0; j < n; j++) {
//                 sb.append('.');
//             }
//             board.add(sb.toString());
//         }
//         //now just start from the 0th row 
//         solve(board, 0);

//         return result;
//     }

//     public void solve(List<String> board, int row) {

//         if (row == board.size()) {
//             result.add(new ArrayList<>(board));
//             return;
//         }
//         //placing a queen at every and check before placing in every direction, from where it can be attacked, i.e diagonally right, left and up, for this isvalid function will be used

//         //traversing in the column now
//         for (int i = 0; i < board.size(); i++) {
//             if (isValid(board, row, i)) {
//                 StringBuilder newRow = new StringBuilder(board.get(row)); //we are not creating any new space, just doing in place changes
//                 newRow.setCharAt(i, 'Q'); //if we found some right place then just to 'Q' from that in that row
//                 board.set(row, newRow.toString()); //replace this new row in the board again

//                 solve(board, row + 1); //now calling for next row

//                 newRow.setCharAt(i, '.'); //backtracking
//                 board.set(row, newRow.toString());
//             }
//         }
//     }
//     //now the isvalid function, in this function we just need to check for three directions as we are going from top to bottom then no need to check from bottom
//     //1. upward, 2. diagonally right, 3.diagonally left

//     public boolean isValid(List<String> board, int row, int col) {
//         //1.looking for up
//         for (int i = row; i >= 0; i--) {
//             if (board.get(i).charAt(col) == 'Q')
//                 return false;
//             //moving in the same column but upward
//         }

//         //2. for right diagonal upwards
//         for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
//             if (board.get(i).charAt(j) == 'Q')
//                 return false;
//         }

//         //3.for left diagonally upwards
//         for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//             if (board.get(i).charAt(j) == 'Q')
//                 return false;
//         }
//         //means if the queen is already placed in that direction then how we can place it in that cell and that's we are checking this condition everytime
//         return true;
//     }
// }
//t.c = O(N!)
//s.c = O(N)