class Solution {
    public int largestInteger(int n, int s) {
        if(n * 9 < s) return -1;

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            min = Math.min(s, 9);
            ans = ans * 10 + min;
            s = s - min;
        }

        return ans;
    }
}