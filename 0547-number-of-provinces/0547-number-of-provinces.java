//we solve this with simple dfs here but we can solve this one with DSU also
// class Solution{
//     boolean[] visited;
//     public int findCircleNum(int[][] isConnected){
//         int V = isConnected.length;
//         visited = new boolean[V];
//         int cnt = 0;

//         for(int i = 0 ; i < V ; i++){
//             if(!visited[i]){
//                 cnt++; //how many times the function calls is equal to the number of provinces present
//                 dfs(i, isConnected);
//             }
//         }
//         return cnt;
//     }

//     public void dfs(int i, int[][] arr){
//         visited[i] = true;
//         for(int j = 0 ; j < arr.length ; j++){
//             if(arr[i][j] == 1 && !visited[j]){
//                 dfs(j, arr);
//             }
//         }
//     }
// }
//here the number of provinces simply mean the numbers of connected graphs and when we do any bfs or dfs everytime the function calls means that node is not present in that particular graph so the number of times our dfs function calls is equal to the number of provinces we have

class Solution{
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                cnt++;

                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.offer(i);

                while(!q.isEmpty()){
                    int curr = q.poll();

                    for(int j = 0 ; j < n ; j++){
                        if(isConnected[curr][j] == 1 && !visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}