class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] ans = new int[queries.length];

        //prefix cnt of plates
        int[] pre = new int[n];
        if(s.charAt(0) == '*'){
            pre[0] = 1;
        }
        
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) == '*'){
                pre[i] = pre[i - 1] + 1;
            }
            else pre[i] = pre[i - 1];
        }

        //nearest candle on left
        int[] left = new int[n];
        int last = -1;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '|'){
                last = i;
            }
            left[i] = last;
        }

        //nearest candle on the right
        int[] right = new int[n];
        last = -1;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == '|'){
                last = i;
            }
            right[i] = last;
        }

        int[] suf = new int[n];
        if(s.charAt(n - 1) == '|'){
            suf[n - 1] = 1;
        }


        for(int i = 0 ; i < queries.length ; i++){
            int first = right[queries[i][0]];
            int secon = left[queries[i][1]];

            if(first == -1 || secon == -1 || first >= secon){
                ans[i] = 0;
            }else{
                ans[i] = pre[secon] - pre[first];
            }
        }
        return ans;
    }
}