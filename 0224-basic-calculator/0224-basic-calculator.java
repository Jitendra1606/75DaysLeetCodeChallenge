class Solution {
    public int calculate(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();

        int res = 0, curr = 0, sign = 1;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch - '0');
            }
            else if(ch == '+'){
                res += curr * sign;
                curr = 0;
                sign = 1;
            }
            else if(ch == '-'){
                res += curr * sign;
                curr = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(res);
                st.push(sign);
                curr = 0;
                res = 0;
                sign = 1;
            }
            else if(ch == ')'){
                res += curr * sign;
                curr = 0;
                res *= st.pop(); //for sign
                res += st.pop(); //already computed result before parantheses
            }
        }

        res += curr * sign;
        return res;
    }
}