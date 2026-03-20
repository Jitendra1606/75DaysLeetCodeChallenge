class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        //creating new 2d array to store the result
        int[][] matrix = new int[m - k + 1][n - k + 1];
        //first two loops to traverse through whole matrix and we can't go further from last row or last column so that's why till i<=m-k and j<=n-k
        for(int i = 0 ; i <= m - k ; i++){
            for(int j = 0 ; j <= n - k ; j++){
                //creating a new list everytime to store the elements of k X k matrix everytime and later we will sort the list for ease
                List<Integer> list = new ArrayList<>();
                for(int l = i ; l < i + k ; l++){
                    for(int u = j ; u < j + k ; u++){
                        //adding elements in the list
                        list.add(grid[l][u]);
                    }
                }
                //if list contains only 1 element then it means it's only absolute differnce is with itself which is 0
                if(list.size() == 1){
                    matrix[i][j] = 0;
                    continue;
                }
                //sorting the list so the elements are arranged in increasing order and we can get min easily
                Collections.sort(list);

                if (list.get(0).equals(list.get(list.size() - 1))) {
                    matrix[i][j] = 0;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                //now to get the min value out of our given list and then storing it in our result matrix 
                for(int x = 0 ; x < list.size() - 1 ; x++){
                    //if there are duplicate values present then it will give ans 0 which is wrong bcz we are asked about distinct elements only
                    if(list.get(x).equals(list.get(x + 1))) continue;
                    int dif = list.get(x + 1) - list.get(x);
                    min = Math.min(min, dif);
                    
                }
                matrix[i][j] = min;
            }
        }
        return matrix;
    }
}