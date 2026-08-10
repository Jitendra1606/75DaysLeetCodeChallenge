class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();

        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dis = road[2];

            adj.get(u).add(new Pair(v, dis));
            adj.get(v).add(new Pair(u, dis));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Long.compare(x.first, y.first));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            long dis = cur.first;
            int node = cur.second;

            if (dis > dist[node])
                continue;

            for (Pair p : adj.get(node)) {
                int adjNode = (int) p.first;
                long adjDist = p.second;

                if (adjDist + dis < dist[adjNode]) {
                    dist[adjNode] = adjDist + dis;

                    pq.offer(new Pair(dis + adjDist, adjNode));
                    ways[adjNode] = ways[node];
                    
                } else if (dis + adjDist == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}

class Pair {
    long first;
    int second;

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

// Now reach node 3 from node 2

// Again:

// dist[2] + edge(2,3)
// = 5 + 5
// = 10

// But now:

// dist[3] = 10

// So:

// 10 == dist[3]

// This means:

// "Oh! We found ANOTHER path having exactly the same shortest distance."

// Therefore:

// ways[3] = ways[3] + ways[2];
// ways[3] = 1 + 1
//         = 2

// Now:

// ways[3] = 2

// And the two paths are:

// 0 → 1 → 3
// 0 → 2 → 3