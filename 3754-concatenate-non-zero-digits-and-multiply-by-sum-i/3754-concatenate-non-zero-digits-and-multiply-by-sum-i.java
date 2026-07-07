class Solution {
    public long sumAndMultiply(int n) {
        int x = n;
        long sum = 0;

        while (x != 0) {
            int rem = x % 10;
            sum += rem;
            x = x / 10;
        }

        long mul = 0;
        String s = Integer.toString(n);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '0'){
                mul = mul * 10 + (s.charAt(i) - '0');
            }
        }
        return mul * sum;
    }
}