class Solution{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){

            // Remove indices that are out of the current window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store answer once first window is formed
            if(i >= k - 1){
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}







//brute force(tle - 44/52)
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         List<Integer> list = new ArrayList<>();
//         int max = Integer.MIN_VALUE;

//         for(int i = 0 ; i <= n - k ; i++){
//             max = nums[i];

//             for(int j = i + 1 ; j < i + k ; j++){
//                 max = Math.max(max, nums[j]);
//             }

//             list.add(max);
//         }

//         int[] ans = new int[list.size()];
//         for(int i = 0 ; i < list.size() ; i++){
//             ans[i] = list.get(i);
//         }
//         return ans;
//     }
// }