class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] rowCnt = new int[n]; //to cnt the occurences of each value of that row orr column
        int[] colCnt = new int[m];

        Map<Integer, int[]> map = new HashMap<>();

        //creating a map to precompute the position of each no. in the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int value = mat[row][col];

                map.put(value, new int[] { row, col }); //putting as a pair for (row, col)
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i]; //current no. of array arr
            int[] pos = map.get(num); //getting (row, col) of that value in the matix array
            int row = pos[0]; //for row to be updated
            int col = pos[1]; //for col to be updated

            rowCnt[row]++; //incrementing that row where the value was foumd
            colCnt[col]++; //incrementing that col where the value was foumd

            if (rowCnt[row] == m || colCnt[col] == n)
                return i; //if any cnt becomes equal then simply return
        }
        return -1;
    }
}