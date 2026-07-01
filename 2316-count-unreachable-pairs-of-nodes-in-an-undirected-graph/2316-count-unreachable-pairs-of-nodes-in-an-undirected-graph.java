class Solution {

    boolean[] visit;

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visit = new boolean[n];

        long ans = 0;
        long remaining = n;

        for(int i = 0 ; i < n ; i++){
            if(!visit[i]){
                int size = dfs(i, adj);
                
                remaining -= size;
                ans += (long)size * remaining;
            }
        }
        return ans;
    }

    public int dfs(int node, List<List<Integer>> adj){
        visit[node] = true;
        int size = 1;

        for(int next : adj.get(node)){
            if(!visit[next]){
                size += dfs(next, adj);
            }
        }
        return size;
    }
}