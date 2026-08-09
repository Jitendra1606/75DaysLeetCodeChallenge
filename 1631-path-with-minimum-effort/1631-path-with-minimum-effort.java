class Solution{
    public int minimumEffortPath(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];

        for(int[] arr : distance){
            Arrays.fill(arr, (int)(1e9));
        }

        distance[0][0] = 0;

        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((x, y) -> x.dif - y.dif);

        q.offer(new Tuple(0, 0, 0));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Tuple cur = q.poll();

            int diff = cur.dif;
            int row = cur.first;
            int col = cur.second;

            if(row == n - 1 && col == m - 1) return diff;

            for(int i = 0 ; i < 4 ; i++){
                int newr = row + drow[i];
                int newc = col + dcol[i];

                if(newr >= 0 && newc >= 0 && newr < n && newc < m){
                    int newEffort = Math.max(diff, Math.abs(heights[newr][newc] - heights[row][col]));

                    if(newEffort < distance[newr][newc]){
                        distance[newr][newc] = newEffort;

                        q.offer(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        return 0;
    }
}

class Tuple {
    int dif;
    int first;
    int second;

    Tuple(int dif, int first, int second) {
        this.dif = dif;
        this.first = first;
        this.second = second;
    }
}