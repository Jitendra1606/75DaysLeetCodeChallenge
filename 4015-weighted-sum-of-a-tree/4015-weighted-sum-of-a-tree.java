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

            height = Math.max(depth[i], height); //to calculate the max height
        }

        //calculating contribution
        for(int i = 0 ; i < n ; i++){
            sum += (1L * nums[i]) * (height - depth[i] + 1);
        }

        return sum;
    }

    //just calculating the depth of tree simply, by recursive calls
    public long traverse(int node, int[] parent, long[] depth){
        if(parent[node] == -1) return 1;

        if(depth[node] != 0){ //initial value of heights of all nodes are 0
            return depth[node];
        }

        //it'll traverse back from the root so depth will keep on adding 
        return depth[node] = traverse(parent[node], parent, depth) + 1;
    }
}