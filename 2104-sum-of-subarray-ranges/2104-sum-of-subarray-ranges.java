//using the concept of sum of subarray min here

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        //finding next smaller to left
        int[] nsl = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        //finding next smaller to right
        int[] nsr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            nsr[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        //finding next greater to left
        int[] ngl = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            ngl[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        //finding next greater to right
        int[] ngr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            ngr[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sumMin = 0;
        long sumMax = 0;

        //just calculating what's asked in the ques
        for (int i = 0; i < n; i++) {
            long left = i - nsl[i];
            long right = nsr[i] - i;

            sumMin += left * right * nums[i];

            left = i - ngl[i];
            right = ngr[i] - i;

            sumMax += left * right * nums[i];
        }
        return sumMax - sumMin;
    }
}