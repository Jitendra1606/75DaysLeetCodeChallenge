// class Solution{
//     int[] drow = {-1, 0, 1, 0};
//     int[] dcol = {0, 1, 0, -1};
//     int n, m;
//     int[][] ans;

//     public int[][] floodFill(int[][] image, int sr, int sc, int color){
//         n = image.length;
//         m = image[0].length;

//         int oldColor = image[sr][sc];
//         if(oldColor == color) return image;

//         ans = image;
//         dfs(image, sr, sc, color, oldColor);
//         return ans;
//     }

//     public void dfs(int[][] image, int row, int col, int color, int oldColor){
//         ans[row][col] = color;

//         for(int i = 0 ; i < 4 ; i++){
//             int newr = drow[i] + row;
//             int newc = dcol[i] + col;

//             if(newr < n && newc < m && newr >= 0 && newc >= 0 && image[newr][newc] == oldColor && ans[newr][newc] != color) dfs(image, newr, newc, color, oldColor);
//         }
//     }
// }



//BFS is slight slow compared to DFS
class Solution{
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int n = image.length;
        int m = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));

        visited[sr][sc] = true;
        image[sr][sc] = color;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int newr = drow[i] + r;
                int newc = dcol[i] + c;

                if(newr < n && newc < m && newr >= 0 && newc >= 0 && !visited[newr][newc] && image[newr][newc] == oldColor){
                    image[newr][newc] = color;
                    visited[newr][newc] = true;
                    q.offer(new Pair(newr, newc));
                }
            }
        }
        return image;
    }
}

class Pair{
    int row;
    int col;

    Pair(int r, int c){
        row = r;
        col = c;
    }
}