class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = val;
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else{
            if(v >= min){
                st.push(v);
            }else{
                st.push(2 * v - min);
                min = v;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long x = st.pop();
        if(x < min) min = 2 * min - x;        
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(min <= x){
            return (int)x;
        }else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */