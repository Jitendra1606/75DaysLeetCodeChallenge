class Pair{
    int distance;
    int node;

    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < times.length ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adj.get(u).add(new Pair(wt, v));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int)1e9);

        distance[k] = 0;
        pq.offer(new Pair(0, k)); //{distance, node}

        while(!pq.isEmpty()){
            Pair it = pq.poll();
            int d = it.distance;
            int node = it.node;

            for(Pair p : adj.get(node)){
                int wt = p.distance;
                int adjNode = p.node;

                if(d + wt < distance[adjNode]){
                    distance[adjNode] = d + wt;
                    pq.offer(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            if(distance[i] == (int)1e9) return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}