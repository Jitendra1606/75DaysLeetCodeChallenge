class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
        }
        return dfs(0, list, baseTime);
    }

    public long dfs(int node, List<List<Integer>> list, int[] base){
        //base case for leaves
        if(list.get(node).size() == 0) return base[node];

        long latest = 0, earliest = Long.MAX_VALUE;
        for(Integer neigh : list.get(node)){
            long child = dfs(neigh, list, base);
            latest = Math.max(latest, child);
            earliest = Math.min(earliest, child);
        }
        return 2L * latest - earliest + base[node];
    }
}