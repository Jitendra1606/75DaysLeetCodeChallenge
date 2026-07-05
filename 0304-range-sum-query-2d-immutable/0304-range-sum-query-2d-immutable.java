class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int left = 0, up = 0, diag = 0;
                if(i - 1 >= 0){
                    up = prefix[i - 1][j];
                }
                if(j - 1 >= 0){
                    left = prefix[i][j - 1];
                }
                if(i - 1 >= 0 && j - 1 >= 0){
                    diag = prefix[i - 1][j - 1];
                }
                prefix[i][j] = matrix[i][j] + up + left - diag;
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];

        int up = 0, left = 0, diag = 0;

        if(row1 - 1 >= 0){
            up = prefix[row1 - 1][col2];
        }

        if(col1 - 1 >= 0){
            left = prefix[row2][col1 - 1];
        }

        if(row1 - 1 >= 0 && col1 - 1 >= 0){
            diag = prefix[row1 - 1][col1 - 1];
        }
        return total - up - left + diag;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 //here we need to return the sum of some area so after calculating prefix sum for whole array, we need to give the area of that part, that's why we remove those up, low from our prefix ans also


//  Final prefix:
// 1   3   6
// 5   12  21
// 12  27  45

// Now any rectangle query is easy. Suppose:
// sumRegion(1,1,2,2)  Means:

// 5 6
// 8 9

// Answer should: 28
// Take full:
// prefix[2][2] = 45
// Remove upper part: 1 2 3, value: prefix[0][2]=6

// Remove left part:
// 1
// 4
// 7
// value: prefix[2][0]=12

// But 1 got removed twice, add it back:
// prefix[0][0]=1
// Final: 45 - 6 - 12 + 1 = 28
