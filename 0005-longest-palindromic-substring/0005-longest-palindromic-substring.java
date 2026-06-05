class Solution {
    String ans = "";

    public String longestPalindrome(String s) {
        int n = s.length();

        solve(0, s);
        return ans;
    }

    public void solve(int start, String s){
        if(start == s.length()) return;

        for(int end = start ; end < s.length() ; end++){
            String cur = s.substring(start, end + 1);

            if(isPalindrome(cur) && cur.length() > ans.length()){
                ans = cur;
            }
        }
        solve(start + 1, s);
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
