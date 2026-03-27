class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ori = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ori[i][j] = mat[i][j];
            }
        }
        k = k % m;
        
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){ //even row --> left shift
                shiftLeft(mat[i], k);
            }else{
                shiftright(mat[i], k);
            }
        }
        if(same(ori, mat)) return true;
        return false;
    }
    public void shiftLeft(int[] row, int k){
        int n = row.length;
        k = k % n;
        for(int i = 0 ; i < k ; i++){
            int temp = row[0];
            for(int j = 0 ; j < n - 1 ; j++){
                row[j] = row[j + 1];
            }
            row[n - 1] = temp;
        }
    }
    public void shiftright(int[] row, int k){
        int n = row.length;
        k = k % n;
        for(int i = 0 ; i < k ; i++){
            int temp = row[n - 1];
            for(int j = n - 1 ; j > 0 ; j--){
                row[j] = row[j - 1];
            }
            row[0] = temp;
        }
    }
    public boolean same(int[][] mat, int[][] ori){
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] != ori[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}