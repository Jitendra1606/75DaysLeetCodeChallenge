class Solution {
    public int countCommas(int n) {
        // int dig = (int)Math.log10(n) + 1;
        int cnt = 0;
        if(n < 1000) return 0;
        // if(dig <= 3) return 0;
        else{
            // for(int i = 1000; i <= n ; i++){
            //     cnt++;
            // }
            return (n - 1000) + 1;
        }
        // return cnt;
    }
}