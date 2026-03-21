class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = x ; i < x + k / 2 ; i++){
            int l = x + k - 1 - (i - x);
            for(int j = y ; j < y + k ; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[l][j];
                grid[l][j] = temp;
            }
        }
        return grid;
    }
}