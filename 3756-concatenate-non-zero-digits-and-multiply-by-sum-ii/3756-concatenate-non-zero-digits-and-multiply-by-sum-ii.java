class Solution {
    final static int MOD = (int)(1e9 + 7);
    
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        //digit sum prefix
        long[] sumPrefix = new long[n + 1];

        ArrayList<Integer> idx = new ArrayList<>(); //to store index of non zero digits
        ArrayList<Integer> digits = new ArrayList<>(); //to store non zero digits directly without use of any multiplication or any other thing(direct concatenate)

        for(int i = 0 ; i < n ; i++){
            int d = s.charAt(i) - '0';

            sumPrefix[i + 1] = sumPrefix[i] + d;

            if(d != 0){
                idx.add(i);
                digits.add(d);
            }
        }
        int m = digits.size();

        //prefix value of compressed number
        long[] valPrefix = new long[m + 1];

        for(int i = 0 ; i < m ; i++){
            valPrefix[i + 1] = (valPrefix[i] * 10 + digits.get(i)) % MOD;
        }

        //powers of 10
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        for(int i = 1 ; i <= m ; i++){
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for(int q = 0 ; q < queries.length ; q++){
            int l = queries[q][0];
            int r = queries[q][1];

            //sum calculation
            long sum = sumPrefix[r + 1] - sumPrefix[l];

            //find compressed range
            int left = lowerBound(idx, l);
            int right = upperBound(idx, r) - 1;

            //no non zero digit
            if(left > right){
                ans[q] = 0;
                continue;
            }

            int len = right - left + 1;

            //x calculation
            long x = (valPrefix[right + 1] - (valPrefix[left] * pow10[len]) % MOD + MOD) % MOD;

            ans[q] = (int)((x * sum) % MOD);
        }
        return ans;
    }

    //first index >= target
    public int lowerBound(ArrayList<Integer> arr, int tar){
        int l = 0, r = arr.size();

        while(l < r){

            int mid = l + (r - l) / 2;

            if(arr.get(mid) >= tar){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }

    //first index > target
    public int upperBound(ArrayList<Integer> arr, int target){
        int l = 0, r = arr.size();

        while(l < r){
            int mid = l + (r - l) / 2;

            if(arr.get(mid) > target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}





// tle
// class Solution {
//     final static int MOD = (int)(1e9 + 7);
    
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int n = queries.length;

//         int[] ans = new int[n];

//         for(int i = 0 ; i < n ; i++){
//             // StringBuilder sb = new StringBuilder(s.substring(queries[i][0], queries[i][1] + 1));

//             int l = queries[i][0];
//             int r = queries[i][1];

//             int x = 0, sum = 0;
//             // String st = sb.toString();

//             for(int j = l ; j <= r ; j++){
//                 char ch = s.charAt(j);

//                 if(ch != '0'){

//                     int digit = ch - '0';

//                     x = (int)(((long)x * 10 + digit) % MOD);
//                     sum = (sum + digit) % MOD;
//                 }
//             }
//             ans[i] = (int)(((long)x * sum) % MOD);
//         }
//         return ans;
//     }
// }