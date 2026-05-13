class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = n * m - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int element = matrix[mid / m][mid % m];

            if(element == target) return true;

            else if(element < target) low = mid + 1;

            else high = mid - 1;
        }

        return false;
    }
}
//t.c = O(log mn)
//s.c = O(1)

// class Solution{
//     public boolean searchMatrix(int[][] matrix, int target){
//         int n = matrix.length, m = matrix[0].length;

//         int[] res = new int[m * n];
//         for(int i = 0 ; i < m * n ; i++){
//             res[i] = matrix[i / m][i % m];
//         } 

//         int low = 0, high = m * n - 1;
//         while(low <= high){

//             int mid = low + (high - low) / 2;

//             if(res[mid] == target) return true;

//             else if(res[mid] < target) low = mid + 1;

//             else high = mid - 1;
//         }
//         return false;
//     }
// }
//t.c = O(m * n) + O(log m*n)
//s.c = O(m * n)