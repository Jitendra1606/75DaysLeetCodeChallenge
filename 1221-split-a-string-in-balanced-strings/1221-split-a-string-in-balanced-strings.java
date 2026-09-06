class Solution {
    public int balancedStringSplit(String s) {
        int n = s.length();

        int r = 0, l = 0, cnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'R')
                r++;
            else if (ch == 'L')
                l++;

            if (r == l) {
                cnt++;
                r = 0;
                l = 0;
            }
        }
        return cnt;
    }
}