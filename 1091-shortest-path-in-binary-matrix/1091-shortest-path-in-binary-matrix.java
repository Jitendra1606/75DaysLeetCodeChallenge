class Solution{
    public int shortestPathBinaryMatrix(int[][] grid){
        if(grid[0][0] == 1) return -1;

        int n = grid.length;
        int[][] distance = new int[n][n];

        for(int[] arr : distance) Arrays.fill(arr, (int)(1e9));

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(1, 0, 0));

        distance[0][0] = 0;

        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

        while(!q.isEmpty()){
            Tuple cur = q.poll();

            int dis = cur.first;
            int row = cur.second;
            int col = cur.third;

            if(row == n - 1 && col == n - 1) return dis;

            for(int i = 0 ; i < 8 ; i++){
                int newr = row + drow[i];
                int newc = col + dcol[i];

                if(newr >= 0 && newc >= 0 && newr < n && newc < n && grid[newr][newc] == 0 && 1 + dis < distance[newr][newc]){
                    distance[newr][newc] = 1 + dis;

                    q.offer(new Tuple(1 + dis, newr, newc));
                }
            }
        }
        return -1;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}