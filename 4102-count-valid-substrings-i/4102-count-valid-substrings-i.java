class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        int left = 0;
        long cnt = 0;

        for(int  right = 0 ; right < n ; right++){
            if(right >= 2 && s.charAt(right - 2) == 'a' && s.charAt(right - 1) == 'b' && s.charAt(right) == 'c') left = right - 1;

            cnt += (right - left + 1);
        }

        return cnt;
    }
}