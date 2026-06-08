class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        char[] arr = num.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && (st.peek() - '0') > (arr[i] - '0') && k > 0){
                st.pop();
                k--;
            }
            st.push(arr[i]);
        }
        //edge case when none number popped out "123456" k = 3, so we'll remove last k elements
        while(k > 0){
            st.pop();
            k--;
        }
        //edge case, if none element is present
        if(st.isEmpty()){
            return "0";
        }
        //storing answer in the stringbuilder
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        //again this is an edge case when there is leading zeroes "0123",so del this zero is imp.
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}