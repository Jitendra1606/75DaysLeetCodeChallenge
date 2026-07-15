class Solution{
    public List<Long> minOperations(int[] nums, int[] queries){
        int n = nums.length;
        List<Long> ans = new ArrayList<>();

        Arrays.sort(nums);

        long[] pre = new long[n + 1];

        for(int i = 1 ; i <= n ; i++){
            pre[i] = nums[i - 1] + pre[i - 1];
        }

        for(int x : queries){
            int i = find(nums, x);

            long left = 1L * i * x - (pre[i]);
            long right = ((pre[n] - pre[i]) - (1L * (n - i) * x));

            ans.add(left + right);
        }
        return ans;
    }

    public int find(int[] nums, int x){
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}




// class Solution {
//     public List<Long> minOperations(int[] nums, int[] queries) {
//         int n = nums.length;

//         List<Long> ans = new ArrayList<>();
        

//         for(int i = 0 ; i < queries.length ; i++){
//             long cnt = 0;
//             for(int j = 0 ; j < n ; j++){
//                 cnt += Math.abs(nums[j] - queries[i]);
//             }
//             ans.add(cnt);
//         }
//         return ans;
//     }
// }