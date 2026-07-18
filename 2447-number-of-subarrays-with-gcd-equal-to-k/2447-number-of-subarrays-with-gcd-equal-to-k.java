class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int gc = 0;
            for (int j = i; j < n; j++) {
                gc = gcd(gc, nums[j]);

                if (gc == k)
                    cnt++;

                if (gc < k || gc % k != 0)
                    break;
            }
        }
        return cnt;
    }


    public int gcd(int a, int b) {
        // while (b != 0) {
        //     int temp = b;
        //     b = a % b;
        //     a = temp;
        // }
        // return a;

      
        if(b==0) return a;
        return gcd(b, a%b);
    
    }
}

// Remember an important property:
// gcd only stays the same or decreases.
// It can never increase.

// So if, gc < k
// then it can never become k later.

// Also, if
// gc % k != 0

// then it can never become k.

// Example:

// gc = 14
// k = 6

// Future GCDs are divisors of 14:

// 14
// 7
// 2
// 1

// You'll never reach 6.