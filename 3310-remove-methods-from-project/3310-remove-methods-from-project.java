class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < invocations.length ; i++){
            int first = invocations[i][0];
            int second = invocations[i][1];

            list.get(first).add(second);
        }

        boolean[] arr = new boolean[n];
        dfs(list, k, arr);

        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            if(!arr[u] && arr[v]){
                List<Integer> ans = new ArrayList<>();

                for(int i = 0 ; i < n ; i++){
                    ans.add(i);
                }

                return ans;
            }
        }

        //return remaining(non-suspicious) methods
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!arr[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public void dfs(List<List<Integer>> list, int k, boolean[] arr){
        if(arr[k]) return;

        arr[k] = true;

        for(int next : list.get(k)){
            dfs(list, next, arr);
        }
    }
}