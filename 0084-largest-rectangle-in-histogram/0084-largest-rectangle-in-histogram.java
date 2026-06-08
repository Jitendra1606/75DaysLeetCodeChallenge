//going with concept of nsl(next smaller to left) and next smaller to right and * by width
class Solution{
    public int largestRectangleArea(int[] heights){
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int[] nsl = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            nsl[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        int[] nsr = new int[n];
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            nsr[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        int[] width = new int[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            width[i] = nsr[i] - nsl[i] - 1;
            ans = Math.max(ans, heights[i] * width[i]);
        }
        return ans;
    }
}