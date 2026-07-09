//in this question first we need to build the components according to the given nums array and maxDiff variable, if the condition is true then those nodes belong to the same componet otherwise belongs to the different component and the nums array is already sorted that's why we just need to check the adjacent nodes diff and once the connected component array is created we can simply ans the queries if two nodes belong to the same component then they are making a path o/w not

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] components = new int[n];

        int comp = 0;

        //first elemnt belong to component 0
        components[0] = comp; 


        //now just create components
        for(int i = 1 ; i < n ; i++){

            if(nums[i] - nums[i - 1] > maxDiff){
                comp++; //means it belong to different component
            }

            components[i] = comp;
        }

        //now just ans the queries
        boolean[] ans = new boolean[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(components[u] == components[v]){ //means both nodes belonges to the same componets
                ans[i] = true;
            }
        }
        return ans;
    }
}