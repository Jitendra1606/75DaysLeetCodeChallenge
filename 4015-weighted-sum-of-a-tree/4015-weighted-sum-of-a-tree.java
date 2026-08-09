class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        long[] depth = new long[n];
        depth[0] = 1;

        long sum = 0;
        long height = 1;

        for(int i = 0 ; i < n ; i++){
            if(depth[i] == 0){
                traverse(i, parent, depth);
            }

            height = Math.max(height, depth[i]);
        }

        for(int i = 0 ; i < n ; i++){
            sum += (nums[i] * 1L) * (height - depth[i] + 1);
        }

        return sum;
    }

    public long traverse(int node, int[] parent, long[] depth){
        if(parent[node] == -1) return 1;

        if(depth[node] != 0) return depth[node];

        return depth[node] = traverse(parent[node], parent, depth) + 1;
    }
}