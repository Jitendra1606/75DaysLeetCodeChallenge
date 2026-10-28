class Solution{
    public int minCost(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][1024];

        return solve(0, 0, n, m, grid[0][0], grid, dp);
    }

    public int solve(int i, int j, int n, int m, int xor, int[][] grid, Integer[][][] dp){
        if(i == n - 1 && j == m - 1) return xor;

        if(dp[i][j][xor] != null) return dp[i][j][xor];

        int right = Integer.MAX_VALUE;
        if(j < m - 1){
            right = solve(i, j + 1, n, m, xor ^ grid[i][j + 1], grid, dp);
        }

        int down = Integer.MAX_VALUE;
        if(i < n - 1){
            down = solve(i + 1, j, n, m, xor ^ grid[i + 1][j], grid, dp);
        }

        return dp[i][j][xor] = Math.min(right, down);
    }
}


// class Solution {
//     public int minCost(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][][] dp = new int[m + 1][n + 1][1024];
//         for(int[][] mat : dp){
//             for(int[] rows : mat){
//                 Arrays.fill(rows, -1);
//             }
//         }
//         return solve(0, 0, m, n, grid[0][0], grid, dp);
//     }
//     public int solve(int i, int j, int m, int n, int xor, int[][] grid, int[][][] dp){
//         if(i == m - 1  && j == n - 1) return xor;
//         if(dp[i][j][xor] != -1) return dp[i][j][xor];
//         int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
//         if(j < n - 1){
//             right = solve(i, j + 1, m, n, xor ^ grid[i][j + 1], grid, dp);
//         }
//         if(i < m - 1){
//             down = solve(i + 1, j, m, n, xor ^ grid[i + 1][j], grid, dp);
//         }
//         return dp[i][j][xor] = Math.min(right, down);
//     }
// }


// class Solution {
//     public int minCost(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         return solve(0, 0, m, n, grid[0][0], grid);
//     }
//     public int solve(int i, int j, int m, int n, int xor, int[][] grid){
//         if(i == m - 1  && j == n - 1) return xor;
//         int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
//         if(j < n - 1){
//             right = solve(i, j + 1, m, n, xor ^ grid[i][j + 1], grid);
//         }
//         if(i < m - 1){
//             down = solve(i + 1, j, m, n, xor ^ grid[i + 1][j], grid);
//         }
//         return Math.min(right, down);
//     }
// }