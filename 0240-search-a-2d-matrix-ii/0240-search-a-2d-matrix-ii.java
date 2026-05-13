class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        int row = 0, col = m - 1;

        while(row < n && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }

            else if(matrix[row][col] > target){
                col--;
            }

            else{
                row++;
            }
        }

        return false;
    }
}
//t.c = O(m + n)
//s.c = O(1)

// 
//for this question we will search in each row if last index's number is smaller than target then there is no meaning searching in that row, so increase the row index o/w do the normal bs on that row

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length, m = matrix[0].length;
//         int i = 0;

//         while(i < n){
//             if(matrix[i][m - 1] < target) i++; //serach in next row
//             else{
//                 if(isPresent(matrix, i, target)) return true;
//                 else i++;
//             }
//         }
//         return false;
//     }

//     public boolean isPresent(int[][] matrix, int i, int target){
//         int m = matrix[0].length;

//         int low = 0, high = m - 1;

//         while(low <= high){

//             int mid = low + (high - low) / 2;

//             if(matrix[i][mid] == target) return true;
            
//             else if(matrix[i][mid] < target) low = mid + 1;

//             else high = mid - 1;
//         }
//         return false;
//     }
// }
//t.c = O(nlog m)
//s.c = O(1)