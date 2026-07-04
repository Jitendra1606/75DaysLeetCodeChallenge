//for this question - Hierholzer Algorithm
class Solution{
    Map<Integer, Stack<Integer>> adj = new HashMap<>();
    List<int[]> path = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
    
        Map<Integer, Integer> degree = new HashMap<>();
        //build graph
        for(int[] p : pairs){
            int u = p[0];
            int v = p[1];

            adj.computeIfAbsent(u, x -> new Stack<>()).push(v);

            degree.put(u, degree.getOrDefault(u, 0) + 1);
            degree.put(v, degree.getOrDefault(v, 0) - 1);
        }

        int start = pairs[0][0];

        //find Euler path starting node
        for(int node : degree.keySet()){
            if(degree.get(node) == 1){
                start = node;
                break;
            }
        }

        dfs(start);

        Collections.reverse(path);

        int[][] ans = new int[path.size()][2];

        for(int i = 0 ; i < path.size() ; i++){
            ans[i] = path.get(i);
        }

        return ans;
    }

    public void dfs(int node){
        Stack<Integer> stack = adj.get(node);

        while(stack != null && !stack.isEmpty()){
            int next = stack.pop();
            dfs(next);
            path.add(new int[]{node, next});
        }
    }
}








// tle with this approach -> as t.c = O(n^2)
// class Solution {
//     List<int[]> list;
//     boolean[] visited;

//     public int[][] validArrangement(int[][] pairs) {
//         list = new ArrayList<>();
//         visited = new boolean[pairs.length];

//         for (int i = 0; i < pairs.length; i++) {

//             list.clear();
//             Arrays.fill(visited, false);

//             dfs(i, pairs);

//             if (list.size() == pairs.length)
//                 break;
//         }


//         int[][] ans = new int[list.size()][2];

//         for (int i = 0; i < list.size(); i++) {
//             ans[i] = list.get(i);
//         }

//         return ans;
//     }


//     public boolean dfs(int row, int[][] pairs) {

//         visited[row] = true;
//         list.add(pairs[row]);

//         if (list.size() == pairs.length)
//             return true;

//         for (int i = 0; i < pairs.length; i++) {

//             if (!visited[i] && pairs[row][1] == pairs[i][0]) {

//                 if (dfs(i, pairs))
//                     return true;
//             }
//         }

//         // backtracking
//         visited[row] = false;
//         list.remove(list.size() - 1);

//         return false;
//     }
// }