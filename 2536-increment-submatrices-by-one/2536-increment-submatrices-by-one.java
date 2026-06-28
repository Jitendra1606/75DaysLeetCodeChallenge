class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for(int[] rows : queries){
            int row1 = rows[0];
            int col1 = rows[1];
            int row2 = rows[2];
            int col2 = rows[3];

            diff[row1][col1] += 1;
            
            if(row2 + 1 < n) diff[row2 + 1][col1] -= 1;
            if(col2 + 1 < n) diff[row1][col2 + 1] -= 1;
            if(row2 + 1 < n && col2 + 1 < n) diff[row2 + 1][col2 + 1] += 1;
        }

        int[][] ans = new int[n][n]; //prefix sum of 2d array

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){

                int top = (i > 0) ? ans[i - 1][j] : 0;
                int left = (j > 0) ? ans[i][j - 1] : 0;
                int topLeft = (i > 0 && j > 0) ? ans[i - 1][j - 1] : 0;

                ans[i][j] = diff[i][j] + top + left - topLeft;
            }
        }

        return ans;
    }
}

// in 2d it looks like this
//        col1      col2+1
//         +--------- -
//         |          |
//         |Rectangle |
//         |          |
//         ----------- +
//       row2+1