class Solution {
    int n, m;
    boolean[][] visit;
    int maxRow, maxCol;

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    public int[][] findFarmland(int[][] land) {
        n = land.length;
        m = land[0].length;

        visit = new boolean[n][m];

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && land[i][j] == 1) {
                    maxRow = 0;
                    maxCol = 0;

                    dfs(i, j, land);
                    int[] arr = new int[]{i, j, maxRow, maxCol};
                    result.add(arr);
                }
            }
        }
        return result.stream().toArray(int[][] :: new);
    }

    public void dfs(int row, int col, int[][] land){
        visit[row][col] = true;

        maxRow = Math.max(maxRow, row);
        maxCol = Math.max(maxCol, col);

        for(int i = 0 ; i < 4 ; i++){
            int newr = drow[i] + row;
            int newc = dcol[i] + col;

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && !visit[newr][newc] && land[newr][newc] == 1){
                dfs(newr, newc, land);
            }
        }
    }
}