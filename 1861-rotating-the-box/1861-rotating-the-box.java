class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] result = new char[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = boxGrid[n - 1 - j][i];
            }
        }
        //we will traverse column wise
        for(int j = 0 ; j < n ; j++){
            int k = m - 1;
            for(int i = m - 1 ; i >= 0 ; i--){
                if(result[i][j] == '*'){
                    k = i - 1;
                }else if(result[i][j] == '#'){
                    result[i][j] = '.';
                    result[k][j] = '#';
                    k--;
                }
            }
        }
        return result;
    }
}