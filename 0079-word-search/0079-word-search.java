class Solution {
    int n, m, l;

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        l = word.length();

        visited = new boolean[n][m];

        if (n * m < l)
            return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (word.charAt(0) == board[i][j]){
                    if(solve(0, i, j, board, word))
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(int ind, int i, int j, char[][] board, String word) {
        if (ind == l - 1)
            return true;

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newr = drow[k] + i;
            int newc = dcol[k] + j;

            if (newr < n && newc < m && newr >= 0 && newc >= 0 && !visited[newr][newc]
                    && board[newr][newc] == word.charAt(ind + 1)) {
                if (solve(ind + 1, newr, newc, board, word))
                    return true;
            }
        }
        visited[i][j] = false;

        return false;
    }
}

// class Solution {

//     int n, m, l;
//     int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //to travel in all 4 directions

//     public boolean exist(char[][] board, String word) {
//         m = board.length;
//         n = board[0].length;
//         l = word.length();

//         if (n * m < l)
//             return false;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == word.charAt(0) && find(board, 0, i, j, word)) {
//                     return true;
//                 } //first we need to find the first character of the asked word in the matrix
//             } //to start the searching of whole word
//         }
//         return false;
//     }

//     public boolean find(char[][] board, int idx, int i, int j, String word) {
//         if (idx >= l) {
//             return true;
//         }
//         //edge cases
//         if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(idx)) {
//             return false;
//         }
//         char temp = board[i][j];//temp is used to restore the original character after backtracking
//         board[i][j] = '#'; //marking it as visited, so not to explore it again(hehe..)

//         for (int[] dir : directions) {

//             int new_i = i + dir[0]; //to go and check in all directions
//             int new_j = j + dir[1]; //lef, right, up, down

//             if (find(board, idx + 1, new_i, new_j, word)) {
//                 return true;
//             }
//         }
//         board[i][j] = temp;
//         return false;
//     }
// }
// //t.c = O(m⋅n⋅3^L)
// //s.c = O(L), L = word's length