class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            int c = ch - 'a';
            int req = 26 - c;
            int ind = i + 1;

            sum += (ind * (req));
        }

        return sum;
    }
}