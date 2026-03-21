//self
// class Solution {
//     public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
//         int m = grid.length;
//         int n = grid[0].length;
//         for(int i = x ; i < x + k / 2 ; i++){
//             int l = x + k - 1 - (i - x); // took help here
//             for(int j = y ; j < y + k ; j++){
//                 int temp = grid[i][j];
//                 grid[i][j] = grid[l][j];
//                 grid[l][j] = temp;
//             }
//         }
//         return grid;
//     }
// }

//with help
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;
        while (top < bottom) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            top++;
            bottom--;
        }
        return grid;
    }
}