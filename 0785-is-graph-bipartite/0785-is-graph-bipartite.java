//bipartite graph vo hota h jisme agar ham kisi 2 color se uski nodes ko paint kre to uski adjacent nodes ka color kbhi same na ho jaye.
//linear graph(w/o cycle) : always bipartite
//cyclic graph : if cycle's length is even then bipartite otherwise not


class Solution{
    int[] color;
    public boolean isBipartite(int[][] graph){
        int V = graph.length;

        color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0 ; i < V ; i++){
            if(color[i] == -1){
                if(!bfs(i, graph)) return false;
            }
        }
        return true;
    }

    public boolean bfs(int node, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0; //initially put color as 0

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int it : graph[curr]){
                if(color[it] == -1){
                    color[it] = 1 - color[curr];
                    q.offer(it);
                }
                else if(color[it] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}





// //DFS
// // class Solution {
// //     int[] color;
// //     public boolean isBipartite(int[][] graph) {
// //         int V = graph.length;
// //         color = new int[V];
// //         Arrays.fill(color, -1);

// //         for(int i = 0 ; i < V ; i++){
// //             if(color[i] == -1){
// //                 if(!dfs(i, 0, graph)) return false; 
// //             }
// //         }   
// //         return true;
// //     }
// //     public boolean dfs(int node, int col, int[][] graph){
// //         color[node] = col;
// //         for(int it : graph[node]){
// //             if(color[it] == -1){
// //                 if(!dfs(it, 1 - col, graph)) return false;
// //             }else if(color[it] == col){
// //                 return false;
// //             }
// //         }
// //         return true;
// //     }
