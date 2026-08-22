class Solution {
    public boolean checkDivisibility(int n) {
        int isSum = sum(n);
        int ismul = mul(n);

        return n % (isSum + ismul) == 0 ? true : false;
    }

    public int sum(int n){
        int tot = 0;

        while(n > 0){
            tot += (n % 10);

            n /= 10;
        }

        return tot;
    }

    
    public int mul(int n){
        int tot = 1;

        while(n > 0){
            tot *= (n % 10);

            n /= 10;
        }

        return tot;
    }
}