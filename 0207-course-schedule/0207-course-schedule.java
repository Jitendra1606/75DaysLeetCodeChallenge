//Cycle detection in directed graph using dfs
class Solution{
    boolean[] visited;
    boolean[] pathVis;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        
        List<List<Integer>> adj = new ArrayList<>();
        
        visited = new boolean[numCourses];
        pathVis = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(dfs(i, adj)) return false; //means cycle exists
        }
        return true; //no cycle exists
    }

    public boolean dfs(int node, List<List<Integer>> adj){
        visited[node] = true;
        pathVis[node] = true;

        for(Integer it : adj.get(node)){
            if(!visited[it]){
                if(dfs(it, adj)) return true;
            }
            else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}



//Topological sort kahn's algo(BFS)
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         //creating an adjacency list
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i = 0 ; i < numCourses ; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i = 0 ; i < prerequisites.length ; i++){
//             int u = prerequisites[i][0];
//             int v = prerequisites[i][1];
//             adj.get(v).add(u);
//         }
//         int[] indegree = new int[numCourses];
//         for(int i = 0 ; i < numCourses ; i++){
//             for(Integer it : adj.get(i)){
//                 indegree[it]++; //marking the indegree of each node
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0 ; i < numCourses ; i++){
//             if(indegree[i] == 0){
//                 q.offer(i);
//             }
//         }
//         int cnt = 0;
//         while(!q.isEmpty()){
//             int node = q.poll();
//             cnt++;
//             for(Integer it : adj.get(node)){
//                 indegree[it]--;
//                 if(indegree[it] == 0) q.offer(it);
//             }
//         }
//         return cnt == numCourses;
//     }
// }