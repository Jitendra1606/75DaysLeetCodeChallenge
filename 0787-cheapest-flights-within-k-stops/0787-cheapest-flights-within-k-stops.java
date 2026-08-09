class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (int[] fly : flights) {
            int u = fly[0];
            int v = fly[1];
            int cost = fly[2];

            adj.get(u).add(new Pair(v, cost));
        }

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(0, src, 0)); //{stops, {node, dist}}

        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple cur = q.poll();

            int stops = cur.first;
            int node = cur.second;
            int cost = cur.third;

            if (stops > k)
                continue;

            for (Pair p : adj.get(node)) {
                int adjNode = p.first;
                int adjDist = p.second;

                if (stops <= k && cost + adjDist < dist[adjNode]) {
                    dist[adjNode] = cost + adjDist;

                    q.offer(new Tuple(stops + 1, adjNode, cost + adjDist));
                }
            }
        }
        if (dist[dst] == (int) 1e9)
            return -1;

        return dist[dst];
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}