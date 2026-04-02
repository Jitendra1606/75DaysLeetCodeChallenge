class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            if(st.isEmpty()){
                ans[i] = 0;
            }
            else if(!st.isEmpty() && temperatures[i] < temperatures[st.peek()]){
                ans[i] = 1;
            }
            else if(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = 0;
                }else{
                    ans[i] = st.peek() - i;
                }
            }
            st.push(i);
        }
        return ans;
    }
}