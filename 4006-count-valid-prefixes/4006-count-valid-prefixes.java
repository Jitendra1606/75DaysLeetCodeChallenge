class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();
        int cnt = 0, cnt1 = 0, cnt2 = 0;

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) % 2 == 0){
                cnt1++;
            }else{
                cnt2++;
            }

            if(Math.abs(cnt1 - cnt2) <= 1) cnt++;
        }
        return cnt;
    }
}