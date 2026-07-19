// it's only like smallest subsequence of length k
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] result = new int[k];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()] && (st.size() + n - i) > k){
                st.pop();
            }

            if(st.size() < k){
                st.push(i);
            }
        }

        for(int i = k - 1 ; i >= 0 ; i--){
            result[i] = nums[st.pop()];
        }

        return result;
    }
}