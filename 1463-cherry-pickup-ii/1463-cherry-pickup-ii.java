class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, m - 1, n, m, grid, dp);
    }

    public int solve(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp){
        
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)(-1e9);
        
        if(i == n - 1){
            if(j1 == j2) return grid[i][j1]; //conditiions in the question
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = (int)(-1e9);
        int cur = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){ //with given movements in question
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){ //these are all 9 possibilities for col to col
                
                int ans = cur + solve(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
                max = Math.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;
    }
}


// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         return solve(0, 0, m - 1, n, m, grid);
//     }

//     public int solve(int i, int j1, int j2, int n, int m, int[][] grid){
        
//         if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)(-1e9);
        
//         if(i == n - 1){
//             if(j1 == j2) return grid[i][j1]; //conditiions in the question
//             else return grid[i][j1] + grid[i][j2];
//         }
        
//         int max = (int)(-1e9);
//         int cur = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        
//         for(int dj1 = -1 ; dj1 <= 1 ; dj1++){ //with given movements in question
//             for(int dj2 = -1 ; dj2 <= 1 ; dj2++){ //these are all 9 possibilities for col to col
                
//                 int ans = cur + solve(i + 1, j1 + dj1, j2 + dj2, n, m, grid);
//                 max = Math.max(max, ans);
//             }
//         }
//         return max;
//     }
// }