class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            int w = word.indexOf(patterns[i]);
            if(w >= 0) cnt++;
        }
        return cnt;
    }
}