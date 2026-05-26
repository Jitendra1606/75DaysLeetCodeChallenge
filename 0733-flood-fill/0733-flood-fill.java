class Pair{
    int row;
    int col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        visited[sr][sc] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && image[nRow][nCol] == oldColor){
                    image[nRow][nCol] = color;
                    q.offer(new Pair(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }
        return image;
    }
}