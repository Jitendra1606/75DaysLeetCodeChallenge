//is question m ham log ulta chl rhe h aur thoda precomputation bhi kr rhe h, ulta chlne se mtlb
//hm log 0 se distance check nhi krenge sbse close 1 ki blki hm log 1 se uske pass ke 0's ki distance nikal lenge
//phle se hi jo ki manhattan distance hi hogi hmari(pre compute) fir hm log bs binary serach lga kr check kr lenge
//ki jo value hm chah rhe(bdi se bdi) ky usse hm achive kr skte h? jo hm logon ne new array bnai h precomputed data ki
//us array m agar koi bhi value hmari bhji hui value sse km hui to return mar do mtlb smallest value possible h aur
//aur ese hi simple step se hm isko solve kr skte h bs


class Solution {
    int n;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        boolean[][] visited = new boolean[n][n];

        Queue<Tuple> q = new LinkedList<>();
        int[][] ans = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && grid.get(i).get(j) == 1){
                    visited[i][j] = true;
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curRow = q.peek().row;
                int curCol = q.peek().col;
                int curTim = q.peek().time;
                q.poll();

                ans[curRow][curCol] = curTim;

                for(int i = 0 ; i < 4 ; i++){
                    int newr = drow[i] + curRow;
                    int newc = dcol[i] + curCol;

                    if(newr >= 0 && newc >= 0 && newr < n && newc < n && !visited[newr][newc]){
                        q.offer(new Tuple(newr, newc, curTim + 1));
                        visited[newr][newc] = true;
                    }
                }
            }
        }

        int low = 0, high = 2 * (n - 1);
        int result = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(ans, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }

    public boolean check(int[][] ans, int mid){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        if(ans[0][0] < mid) return false;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            if(row == n - 1 && col == n - 1) return true;

            for(int i = 0 ; i < 4 ; i++){
                int newr = drow[i] + row;
                int newc = dcol[i] + col;

                if(newr >= 0 && newc >= 0 && newr < n && newc < n && !visited[newr][newc]){
                    if(ans[newr][newc] >= mid){
                        q.add(new int[]{newr, newc});
                        visited[newr][newc] = true;
                    }
                }
            }
        }
        return false;
    }
}


class Tuple{
    int row;
    int col;
    int time;

    Tuple(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}