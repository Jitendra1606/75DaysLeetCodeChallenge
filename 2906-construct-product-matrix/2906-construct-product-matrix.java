class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        int[] pre = new int[n * m];
        int l = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                pre[l] = grid[i][j] % 12345;
                l++;
            }
        }
        //now we just need to calculte product except self of number

        // Step 2: Prefix product
        int[] prefix = new int[n * m];
        prefix[0] = 1;
        for (int i = 1; i < n * m; i++) {
            prefix[i] = (int)((long)prefix[i - 1] * pre[i - 1] % 12345);
        }

        // Step 3: Suffix product
        int[] suffix = new int[n * m];
        suffix[n * m - 1] = 1;
        for (int i = n * m - 2; i >= 0; i--) {
            suffix[i] = (int)((long)suffix[i + 1] * pre[i + 1] % 12345);
        }
        //final result
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                result[i][j] = (int)((long)prefix[k] * suffix[k] % 12345);
                k++;
            }
        }
        return result;
    }
}

// class Solution{
//     public int[][] constructProductMatrix(int[][] grid){
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][] result = new int[n][m];
//         long pro = 1;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 pro *= grid[i][j];
//             }
//         }
//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 result[i][j] = (int)(pro / grid[i][j]) % 12345;
//             }
//         }
//         return result;
//     }
// }

