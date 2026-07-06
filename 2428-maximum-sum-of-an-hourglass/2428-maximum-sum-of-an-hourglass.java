//we need to find the max sum of an hourglass from evrey matrix
class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int sum = 0;

        for(int i = 0 ; i <= n - 3 ; i++){
            for(int j = 0 ; j <= m - 3 ; j++){
                int ans = 0;

                //upper row
                ans += grid[i][j];
                ans += grid[i][j + 1];
                ans += grid[i][j + 2];

                //middle line
                ans += grid[i + 1][j + 1];

                //bottom line
                ans += grid[i + 2][j];
                ans += grid[i + 2][j + 1];
                ans += grid[i + 2][j + 2];

                sum = Math.max(ans, sum);
            }
        }
        return sum;
    }
}



// Matrix:

// 6 2 1 3
// 4 2 1 5
// 9 2 8 7
// 4 1 2 9

// Take the top-left 3x3:
// 6 2 1
// 4 2 1
// 9 2 8

// Hourglass from this:
// 6 2 1
//   2
// 9 2 8