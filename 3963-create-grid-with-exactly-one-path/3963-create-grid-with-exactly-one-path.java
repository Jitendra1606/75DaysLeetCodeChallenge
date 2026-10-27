class Solution{
    public String[] createGrid(int m, int n){
        char[][] grid = new char[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = '#';
            }
        }

        for(int i = 0 ; i < m ; i++){
            grid[i][0] = '.';
        }

        for(int i = 0 ; i < n ; i++){
            grid[m - 1][i] = '.';
        }

        String[] ans = new String[m];
        for(int i = 0 ; i < m ; i++){
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}


// class Solution{
//     public String[] createGrid(int m, int n){
//         String[] ans = new String[m];
//         ans[0] = ".".repeat(n);

//         String row = "#".repeat(n - 1) + ".";

//         for(int i = 1 ; i < m ; i++){
//             ans[i] = row;
//         }

//         return ans;
//     }
// }


// class Solution {
//     public String[] createGrid(int m, int n) {
//         String[] str = new String[m];

//         char[][] grid = new char[m][n];
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 grid[i][j] = '#';
//             }
//         }

//         for(int i = 0 ; i < n ; i++){
//             grid[0][i] = '.';
//         }

//         for(int i = 0 ; i < m ; i++){
//             grid[i][n - 1] = '.';
//         }

//         for(int i = 0 ; i < m ; i++){
//             str[i] = new String(grid[i]);
//         }

//         return str;
//     }
// }