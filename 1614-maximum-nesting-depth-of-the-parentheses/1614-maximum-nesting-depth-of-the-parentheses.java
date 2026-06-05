class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int cnt = 0, max = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                cnt++;
                max = Math.max(max, cnt);
            }else if(s.charAt(i) == ')'){
                cnt--;
            }
        }
        return max; 
    }
}
//t.c = O(n)
//s.c = O(1)