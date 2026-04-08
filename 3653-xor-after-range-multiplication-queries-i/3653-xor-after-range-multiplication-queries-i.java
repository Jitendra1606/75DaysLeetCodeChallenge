class Solution {
    static final int M = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i] * 1l;
        }
        for(int i = 0 ; i < q ; i++){
            int idx = queries[i][0];

            while(idx <= queries[i][1]){
                arr[idx] = (arr[idx] * queries[i][3]) % M;
                idx += queries[i][2];
            }
        }

        int xor = 0;
        for(int j = 0 ; j < n ; j++){
            xor = xor ^ (int)arr[j];
        }
        return xor;
    }
}