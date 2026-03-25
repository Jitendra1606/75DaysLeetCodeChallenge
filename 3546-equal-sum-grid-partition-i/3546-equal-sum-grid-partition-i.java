class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr1 = new int[m * n];
        int[] arr2 = new int[m * n];
        int k = 0, l = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr1[k] = grid[i][j];
                k++;
            }
        }
        for(int j = 0 ; j < m ; j++){
            for(int i = 0 ; i < n ; i++){
                arr2[l] = grid[i][j];
                l++;
            }
        }
        long tot1 = 0;
        for(int i = 0 ; i < m * n ; i++){
            tot1 += arr1[i];
        }
        long sum1 = 0;
        for(int i = 0 ; i < n * m ; i++){
            sum1 += arr1[i];
            if(sum1 == tot1 - sum1) return true;
        }
        long tot2 = 0;
        for(int i = 0 ; i < m * n ; i++){
            tot2 += arr2[i];
        }
        long sum2 = 0;
        for(int j = 0 ; j < m * n ; j++){
            sum2 += arr2[j];
            if(sum2 == tot2 - sum2) return true;
        }
        return false;
    }
}