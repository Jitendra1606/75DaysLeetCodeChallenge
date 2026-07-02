//same question as p.542
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];

        Queue<Tuple> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && isWater[i][j] == 1){
                    q.offer(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int tim = q.peek().tim;
            q.poll();

            ans[row][col] = tim;

            for(int i = 0 ; i < 4 ; i++){
                int newr = drow[i] + row;
                int newc = dcol[i] + col;

                if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visited[newr][newc] && isWater[newr][newc] == 0){
                    q.offer(new Tuple(newr, newc, tim + 1));
                    visited[newr][newc] = true;
                }
            }
        }
        return ans;
    }
}

class Tuple{
    int row;
    int col;
    int tim;

    Tuple(int row, int col, int tim){
        this.row = row;
        this.col = col;
        this.tim = tim;
    }
}