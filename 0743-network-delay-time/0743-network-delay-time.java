//we are implementing Dijsktra's here to find the shortest path to all nodes from k
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int weight = time[2];

            adj.get(u).add(new Pair(weight, v));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) (1e9));

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(0, k)); //{distance, node}

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            int d = cur.distance;
            int node = cur.node;

            for (Pair p : adj.get(node)) {
                int dis = p.distance;
                int newNode = p.node;

                if (dist[newNode] > dis + d) {
                    dist[newNode] = d + dis;

                    pq.offer(new Pair(d + dis, newNode));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}