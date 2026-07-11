class Solution {
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {
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

        visited = new boolean[n];
        int cnt = 0;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                List<Integer> comp = new ArrayList<>();

                dfs(i, adj, comp);
                ans.add(comp);

                int nodes = comp.size();
                int edgeCnt = 0;

                //edge count
                for (int edge : comp) {
                    edgeCnt += adj.get(edge).size();
                }

                edgeCnt /= 2; //for undirected graph

                if (edgeCnt == ((nodes * (nodes - 1)) / 2)) { //property
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int node, List<List<Integer>> adj, List<Integer> comp) {
        visited[node] = true;
        comp.add(node);

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, adj, comp);
            }
        }
    }
}

// 🔥 Key Idea to Fix
// For each component:

// Count number of nodes = k
// Count number of edges = e
// Check:
// e == k * (k - 1) / 2
// ✅ Correct Approach

// We need to:

// Collect nodes in a component
// Count edges
// Verify completeness

// 🧠 Intuition (Super Important)
// For a complete graph of k nodes:

// Each node connects to (k-1) nodes
// Total edges = k*(k-1)/2

// n = 6
// edges = [[0,1],[0,2],[1,2],[3,4]]

// Components:

// [0,1,2] → edges = 3 → complete ✅
// [3,4] → edges = 1 → complete ✅
// [5] → edges = 0 → complete ✅
// 👉 Answer = 3