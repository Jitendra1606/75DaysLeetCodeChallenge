class Solution{
    boolean[] visited;
    public int findCircleNum(int[][] isConnected){
        int V = isConnected.length;
        visited = new boolean[V];
        int cnt = 0;

        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                cnt++;
                dfs(i, isConnected);
            }
        }
        return cnt;
    }

    public void dfs(int i, int[][] arr){
        visited[i] = true;
        for(int j = 0 ; j < arr.length ; j++){
            if(arr[i][j] == 1 && !visited[j]){
                dfs(j, arr);
            }
        }
    }
}


//we solve this with simple dfs here but we can solve this one with DSU also
// class Solution {
//     boolean visited[];
//     public int findCircleNum(int[][] isConnected) {
//         int V = isConnected.length;
//         visited = new boolean[V];
//         int cnt = 0;
//         for(int i = 0 ; i < V ; i++){
//             if(!visited[i]){
//                 dfs(i, isConnected); //how many times the function calls is equal to the number of provinces present
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
//     public void dfs(int i, int[][] arr){
//         visited[i] = true;
//         for(int j = 0; j < arr.length; j++){
//             if(arr[i][j] == 1 && !visited[j]){
//                 dfs(j, arr);
//             }
//         }
//     } 
// } 
//here the number of provinces simply mean the numbers of connected graphs and when we do any bfs or dfs everytime the function calls means that node is not present in that particular graph so the number of times our dfs function calls is equal to the number of provinces we have