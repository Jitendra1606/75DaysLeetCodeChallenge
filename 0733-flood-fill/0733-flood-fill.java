class Solution{
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int[][] ans;
    int m, n;
        public int[][] floodFill(int[][] image, int sr, int sc, int color){
        n = image.length;
        m = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        ans = image;
        dfs(image, sr, sc, oldColor, color);
        return ans;
    }

    public void dfs(int[][] image, int row, int col, int old, int newColor){
        ans[row][col] = newColor;

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && image[newr][newc] == old && ans[newr][newc] != newColor){
                dfs(image, newr, newc, old, newColor);
            }
        }
    }
}


//BFS is slight slow compared to DFS
// class Pair{
//     int row;
//     int col;
//     Pair(int r, int c){
//         row = r;
//         col = c;
//     }
// }

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int m = image.length;
//         int n = image[0].length;
//         boolean[][] visited = new boolean[m][n];

//         int oldColor = image[sr][sc];
//         if(oldColor == color) return image;

//         Queue<Pair> q = new LinkedList<>();
//         q.offer(new Pair(sr, sc));
//         image[sr][sc] = color;
//         visited[sr][sc] = true;

//         int[] dRow = {-1, 0, 1, 0};
//         int[] dCol = {0, 1, 0, -1};
//         while(!q.isEmpty()){
//             int r = q.peek().row;
//             int c = q.peek().col;
//             q.poll();
//             for(int i = 0 ; i < 4 ; i++){
//                 int nRow = r + dRow[i];
//                 int nCol = c + dCol[i];

//                 if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && image[nRow][nCol] == oldColor){
//                     image[nRow][nCol] = color;
//                     q.offer(new Pair(nRow, nCol));
//                     visited[nRow][nCol] = true;
//                 }
//             }
//         }
//         return image;
//     }
// }