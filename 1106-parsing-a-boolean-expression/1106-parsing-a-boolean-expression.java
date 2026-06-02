class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = expression.charAt(i);

            if(ch == ',') continue;

            if(ch != ')') st.push(ch);

            else{

                int t = 0;
                int f = 0;

                while(st.peek() != '('){ //complete execution of 1 inside bracket first then solve furhter
                    char cur = st.pop();

                    if(cur == 't') t++;
                    else f++;
                }

                st.pop(); //to remove '('

                char op = st.pop(); //to remove the operators 

                if(op == '!'){

                    if(f == 1) st.push('t');
                    else st.push('f');

                }
                else if(op == '|'){

                    if(t > 0) st.push('t');
                    else st.push('f');
                
                }
                else{

                    if(f > 0) st.push('f');
                    else st.push('t');
                }
            }
        }
        return st.peek() == 't';
    }
}