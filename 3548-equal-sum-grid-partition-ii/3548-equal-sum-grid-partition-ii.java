class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long totalsum = 0;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                totalsum += grid[i][j];
            }
        }
        //horizontal cut
        if(checkforcuts(grid, totalsum)) return true;
        reverse(grid);
        if(checkforcuts(grid, totalsum)) return true;
        reverse(grid);
        //transpose

        int[][] transposeGrid = new int[col][row];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                transposeGrid[j][i] = grid[i][j];
            }
        }
        if(checkforcuts(transposeGrid, totalsum)) return true;
        reverse(transposeGrid);
        return checkforcuts(transposeGrid, totalsum);
    }
    public boolean checkforcuts(int[][] grid, long totalsum){
        int m = grid.length;
        int n = grid[0].length;
        long top = 0;
        HashSet<Long> set = new HashSet<>();
        for(int i = 0 ; i <= m - 2 ; i++){
            for(int j = 0 ; j < n ; j++){
                set.add((long)grid[i][j]);
                top += grid[i][j];
            }
            long bottom = (totalsum - top);
            long diff = (top - bottom);

            if(diff == 0) return true;
            if(diff == grid[0][0]) return true;
            if(diff == grid[0][n - 1]) return true;
            if(diff == grid[i][0]) return true;
            if(i > 0 && n > 1 && set.contains(diff)) return true;
        }
        return false;        
    }
    public void reverse(int[][] grid){
        int top = 0, bottom = grid.length - 1;
        while(top < bottom){
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }
}