class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        List<Boolean> list = new ArrayList<>();

        for(int i = 0 ; i < queries.length ; i++){

            boolean[] visited = new boolean[numCourses];

            int first = queries[i][0];
            int second = queries[i][1];

            list.add(dfs(first, second, adj, visited));           
        }

        return list;
    }

    public boolean dfs(int node, int target, List<List<Integer>> adj, boolean[] visited){
        if(node == target) return true;

        visited[node] = true;

        for(int next : adj.get(node)){
            if(!visited[next]){
                
                if(dfs(next, target, adj, visited)) return true;
            }
        }
        return false;
    }
}