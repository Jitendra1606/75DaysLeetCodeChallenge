class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(rows[i] == true || cols[j] == true) matrix[i][j] = 0;
            }
        }
    }
}
//t.c = O(n * n)(for traversing to check for zero) + O(n * n)(to set elements zero)
//s.c = O(1) no extra spaces was needed
