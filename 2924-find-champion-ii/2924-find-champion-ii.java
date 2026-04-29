class Solution {
    public int findChampion(int n, int[][] edges) {
        //just find indegree of each vertex
        int[] indegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
            indegree[v]++;
        }
        int cnt = 0, ans = -1;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                ans = i;
                cnt++;
            }
        }
        if(cnt != 1) return -1;
        return ans;
    }
}


// easy approach
// class Solution {
//     public int findChampion(int n, int[][] edges) {
//         int[] indegree = new int[n];

//         for(int i = 0 ; i < edges.length ; i++){
//             int v = edges[i][1];
//             indegree[v]++;
//         }

//         int cnt = 0, ans = -1;

//         for(int i = 0 ; i < n ; i++){
//             if(indegree[i] == 0){
//                 ans = i;
//                 cnt++;
//             }
//         }

//         return cnt == 1 ? ans : -1;
//     }
// }