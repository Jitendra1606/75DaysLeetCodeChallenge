class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n ; i <= 100 ; i++){
            int prod = produ(i);

            if(prod % t == 0) return i;
        }
        return 0;
    }

    public int produ(int n){
        int prod = 1;

        while(n != 0){
            int rem = n % 10;

            prod = prod * rem;

            n = n / 10;
        }

        return prod;
    }
}