class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
//if we can precompute the no. of 1's in both rows & cols then we can simple calculate zeros also
        int[] rowOne = new int[n];
        int[] colOne = new int[m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                rowOne[i] += grid[i][j];
                colOne[j] += grid[i][j];
            }
        }

        int[][] diff = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int rowZero = m - rowOne[i];
                int colZero = n - colOne[j];

                diff[i][j] = rowOne[i] + colOne[j] - rowZero - colZero;
            }
        }
        return diff;
    }
}