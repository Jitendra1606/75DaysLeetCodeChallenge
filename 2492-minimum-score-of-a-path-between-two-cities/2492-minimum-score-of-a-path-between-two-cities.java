class Solution {
    boolean[] visited;
    int min;
    public int minScore(int n, int[][] roads) {

        min = Integer.MAX_VALUE;
        visited = new boolean[n + 1];

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }

        dfs(1, adj);
        return min;
    }

    public void dfs(int node, List<List<int[]>> adj){
        visited[node] = true;

        for(int[] mat : adj.get(node)){
            int city = mat[0];
            int dis = mat[1];

            min = Math.min(min, dis);

            if(!visited[city]){
                dfs(city, adj);
                visited[city] = true;
            }
        }
    }
}