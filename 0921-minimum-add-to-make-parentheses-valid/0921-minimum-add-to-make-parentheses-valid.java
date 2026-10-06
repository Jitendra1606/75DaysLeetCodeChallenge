class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(')
                open++;

            else {
                if (open > 0)
                    open--;
                else
                    cnt++;
            }
        }
        return open + cnt;
    }
}

// class Solution {
//     public int minAddToMakeValid(String s) {
//         int n = s.length();
//         Stack<Character> st = new Stack<>();

//         for(int i = 0 ; i < n ; i++){
//             char ch = s.charAt(i);

//             if(ch == '('){
//                 st.push('(');
//             }
//             else{
//                 if(!st.isEmpty() && st.peek() == '('){
//                     st.pop();
//                 }else{
//                     st.push(ch); 
//                 }
//             }
//         }
//         return st.size();
//     }
// }
//t.c = O(n)
//s.c = O(n)