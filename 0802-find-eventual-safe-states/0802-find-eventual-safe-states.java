//hmare kaam ki sirf vo nodes h jo cycle nhi bna rhi ho, to simple cycle detection in directed graph
class Solution {
    boolean[] visited;
    boolean[] pathVis;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        visited = new boolean[V];
        pathVis = new boolean[V];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }

        for (int i = 0; i < V; i++) {
            if (!pathVis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int node, int[][] graph) {
        visited[node] = true;
        pathVis[node] = true;

        for (Integer it : graph[node]) {
            if (!visited[it]) {
                if (dfs(it, graph))
                    return true;
            } else if (pathVis[it]) { //means there exists a cycle. so, this node is of no use for us
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}

// class Solution {
//     boolean[] visited;
//     boolean[] pathVis;
//     boolean[] mark;
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         visited = new boolean[V];
//         pathVis = new boolean[V];
//         mark = new boolean[V];
//         for(int i = 0 ; i < V ; i++){
//             if(!visited[i]){
//                 dfs(i, graph);
//             }
//         }
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0 ; i < V ; i++){
//             if(mark[i]) ans.add(i);
//         }
//         return ans;
//     }
//     public boolean dfs(int node, int[][] graph){
//         visited[node] = true;
//         pathVis[node] = true;
//         for(int it : graph[node]){
//             if(!visited[it]){
//                 if(dfs(it, graph)) return true;
//             }else if(pathVis[it]) return true;
//         }
//         pathVis[node] = false;
//         mark[node] = true; //means no cycle here, so this is a safe node
//         return false;
//     }
// }



//reason why we are adding for !pathVis[i] but not for directly at !visited[i]

// Suppose DFS from node 0 explores nodes 1,2,3 and finds they are safe.

// They become:

// visited[1] = true
// visited[2] = true
// visited[3] = true

// But they were never individually added to ans.

// Later loop reaches them:

// if(!visited[i])

// fails, so they get skipped.

// Example:

// 0 -> 1 -> 2

// DFS(0):

// dfs(0)
//    dfs(1)
//       dfs(2) returns false
//    returns false
// returns false

// Your loop adds only:

// ans = [0]

// But answer should be:

// [0,1,2]

// because all are safe.