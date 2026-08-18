class Solution{
    public double myPow(double x, int n){
        return solve(x, (long)n);
    }

    public double solve(double base, long power){
        if(power == 0) return 1;

        if(power < 0) return solve(1 / base, -power);

        if(power % 2 == 0) return solve(base * base, power / 2);
        
        return base * solve(base * base, (power - 1) / 2);
    }
}



// class Solution {
//     public double myPow(double x, int n) {
//         return solve(x, (long)n);
//     }

//     public double solve(double x, long n){
//         if(n == 0) return 1;

//         if(n < 0) return solve(1 / x, -n);

//         if(n % 2 == 0) return solve(x * x, n / 2);
//         else return (x * solve(x * x, (n - 1) / 2));
//     }
// }
//t.c = O(log |n|)
//s.c = O(log |n|)