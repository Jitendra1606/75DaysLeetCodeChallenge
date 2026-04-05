class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        for(int i = 0 ; i < n * m ; i++){
            res[i] = matrix[i / m][i % m];
        }
        int start = 0, end = res.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(res[mid] == target) return true;
            else if(res[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}