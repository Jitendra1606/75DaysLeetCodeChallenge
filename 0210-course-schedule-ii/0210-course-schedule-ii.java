class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // creating adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            // b -> a
            adj.get(b).add(a);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        if(i == numCourses){
            return ans;
        }else{
            return new int[]{};
        }
    }
}