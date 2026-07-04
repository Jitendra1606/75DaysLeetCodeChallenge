class Solution {
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(source, destination, adj);
    }

    public boolean dfs(int source, int destination, List<List<Integer>> adj) {
        if (source == destination)
            return true;

        visited[source] = true;

        for (Integer it : adj.get(source)) {
            if (!visited[it]) {
                if(dfs(it, destination, adj))return true;
            }
        }
        return false;
    }
}
// Time: O(n + edges.length)
// Space: O(n + edges.length)