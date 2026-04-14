class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0 ; i < m ; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int pr = flights[i][2];

            adj.get(u).add(new Pair(v, pr));
        }
        Queue<Tuple> q = new LinkedList<>();
        //{stops, {node, dist}}
        q.offer(new Tuple(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edN = iter.second;

                if(cost + edN < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edN;
                    q.offer(new Tuple(stops + 1, adjNode, cost + edN));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}