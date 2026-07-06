class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        //calculating prefix sum, so we can directly calculate rectangle area like P:304
        int[][] prefix = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int up = 0, left = 0, diag = 0;

                if(i - 1 >= 0){
                    up = prefix[i - 1][j];
                }

                if(j - 1 >= 0){
                    left = prefix[i][j - 1];
                }

                if(i - 1 >= 0 && j - 1 >= 0){
                    diag = prefix[i - 1][j - 1];
                }

                prefix[i][j] = mat[i][j] + up + left - diag;
            }
        }

        int[][] ans = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                
                int topRow = Math.max(0, i - k);
                int leftCol = Math.max(0, j - k);

                int bottomRow = Math.min(n - 1, i + k);
                int rightCol = Math.min(m - 1, j + k);

                int total = prefix[bottomRow][rightCol];

                int up = 0, left = 0, diag = 0;

                if(topRow - 1 >= 0){
                    up = prefix[topRow - 1][rightCol];
                }

                if(leftCol - 1 >= 0){
                    left = prefix[bottomRow][leftCol - 1];
                }

                if(leftCol - 1 >= 0 && topRow - 1 >= 0){
                    diag = prefix[topRow - 1][leftCol - 1];
                }

                ans[i][j] = total - left - up + diag;
            }
        }
        return ans;
    }
}