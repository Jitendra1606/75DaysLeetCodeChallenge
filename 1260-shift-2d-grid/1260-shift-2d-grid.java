class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int total = m * n;
        k = k % total;

        int newIndex = k;
        int[][] temp = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(newIndex == total) newIndex = 0;

                int newx = newIndex / m;
                int newc = newIndex % m;

                temp[newx][newc] = grid[i][j];
                newIndex++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = new ArrayList<>();

            for(int j = 0 ; j < m ; j++){
                list.add(temp[i][j]);
            }

            ans.add(list);
        }

        return ans;
    }
}