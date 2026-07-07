class Solution {
    boolean[] visited;
    boolean[] pathVis;
    Stack<Integer> st;

    public int[] findOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        visited = new boolean[numCourses];
        pathVis = new boolean[numCourses];
        st = new Stack<>();

        int[] ans = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                if(dfs(i, adj)){
                    return new int[]{};
                }
            }
        }

        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    }
  // returns true if cycle exists
    public boolean dfs(int node, List<List<Integer>> adj){
        visited[node] = true;
        pathVis[node] = true;

        for(Integer it : adj.get(node)){
            if(!visited[it]){
                if(dfs(it, adj)){
                    return true;
                }
            }
            else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        st.push(node);

        return false;
    }
}




// class Solution{
//     public int[] findOrder(int numCourses, int[][] prerequisites){

//         List<List<Integer>> adj = new ArrayList<>();

//         for(int i = 0 ; i < numCourses ; i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int[] edge : prerequisites){
//             int u = edge[0];
//             int v = edge[1];

//             adj.get(v).add(u);
//         }       

//         int[] indegree = new int[numCourses];
//         for(int i = 0 ; i < numCourses ; i++){
//             for(Integer it : adj.get(i)){
//                 indegree[it]++;
//             }
//         } 

//         Queue<Integer> q = new LinkedList<>();

//         for(int i = 0 ; i < numCourses ; i++){
//             if(indegree[i] == 0) q.offer(i);
//         }

//         int[] ans = new int[numCourses];

//         int cnt = 0;
//         while(!q.isEmpty()){
//             int node = q.peek();
//             q.poll();

//             ans[cnt++] = node;

//             for(Integer it : adj.get(node)){
//                 indegree[it]--;

//                 if(indegree[it] == 0) q.offer(it); 
//             }
//         }

//         return cnt == numCourses ? ans : new int[]{};
//     }
// }