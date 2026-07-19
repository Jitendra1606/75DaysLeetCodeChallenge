class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        int[] lastOccurence = new int[26];
        for(int i = 0 ; i < n ; i++){
            lastOccurence[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(visited[ch - 'a']) continue;

            while(!st.isEmpty() && st.peek() > ch && lastOccurence[st.peek() - 'a'] > i){
                visited[st.pop() - 'a'] = false;
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}