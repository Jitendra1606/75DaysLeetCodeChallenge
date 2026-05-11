class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        ArrayList<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right){

            for(int col = left ; col <= right ; col++){
                list.add(matrix[top][col]);
            }
            top++;

            for(int row = top ; row <= bottom ; row++){
                list.add(matrix[row][right]);
            }
            right--;

            if(top <= bottom){

                for(int col = right ; col >= left ; col--){
                    list.add(matrix[bottom][col]);
                }

                bottom--;
            }

            if(left <= right){

                for(int row = bottom ; row >= top ; row--){
                    list.add(matrix[row][left]);
                }
                
                left++;
            }
        }
        return list;
    }
}