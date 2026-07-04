class Solution {
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];

        dfs(0, rooms);

        for (boolean room : visited) {
            if (!room)
                return false; //if any node remains unvisited
        }
        return true;
    }

    //simply mark that node where you can reach, and the node which we can't reach remain unvisited
    public void dfs(int node, List<List<Integer>> rooms) {
        visited[node] = true;

        for (Integer it : rooms.get(node)) {
            if (!visited[it])
                dfs(it, rooms);
        }
    }
}