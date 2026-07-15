class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n * m];
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[k] = grid[i][j];
                k++;
            }
        }

        Arrays.sort(arr);
        
        int target = arr[arr.length / 2];
        int ops = 0;

        for(int num : arr){
            if((num - target) % x != 0) return -1;

            ops += Math.abs(num - target) / x;
        }

        return ops;
    }
}