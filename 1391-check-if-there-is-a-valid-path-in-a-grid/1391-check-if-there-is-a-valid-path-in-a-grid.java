class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        //we are defining the movements according to question 
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(1, new int[][]{{0, -1}, {0, 1}});
        map.put(2, new int[][]{{-1, 0}, {1, 0}});
        map.put(3, new int[][]{{0, -1}, {1, 0}});
        map.put(4, new int[][]{{0, 1}, {1, 0}});
        map.put(5, new int[][]{{0, -1}, {-1, 0}});
        map.put(6, new int[][]{{0, 1}, {-1, 0}});

        //now we'll do the simple bfs and putting the cordinates in queue so that we can easily tarverse throught the grid with the help of coordinates as we also stores the coordinates in the map
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll(); //accessing the coordinates from the queue
            int i = cur[0];
            int j = cur[1];

            //last cordinates(our answer)
            if(i == n - 1 && j == m - 1) return true;

            for(int[] dir : map.get(grid[i][j])){
                int nr = i + dir[0];
                int nc = j + dir[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])continue;

                for(int[] back : map.get(grid[nr][nc])){
                    if(nr + back[0] == i && nc + back[1] == j){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }
}