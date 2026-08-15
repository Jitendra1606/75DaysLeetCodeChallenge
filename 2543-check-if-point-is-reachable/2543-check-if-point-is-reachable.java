//since subtraction preserves the order of gcd, gcd(a, b) = gcd(a - b, b) or gcd(a, b - a)
//therefore, we can remove the 2's factor and then check gcd, if it is not 1 then not possible, 
class Solution {
    public boolean isReachable(int targetX, int targetY) {

        while (targetX % 2 == 0) {
            targetX /= 2;
        }

        while (targetY % 2 == 0) {
            targetY /= 2;
        }

        return gcd(targetX, targetY) == 1;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

// 1. What are we actually trying to check?

// The operations are:

// (x, y-x)
// (x-y, y)
// (2x, y)
// (x, 2y)

// We start from:

// (1,1)

// The important observation is:

// Subtraction does NOT change the GCD

// For example:

// gcd(6, 10) = 2

// After subtraction:

// (6,10) → (6,4)

// and:

// gcd(6,4) = 2

// Again:

// (6,4) → (2,4)

// and:

// gcd(2,4) = 2

// So subtraction preserves the GCD.

// 2. Doubling only introduces factors of 2

// Suppose:

// (1,1)

// Double x:

// (1,1) → (2,1)

// GCD:

// gcd(2,1) = 1

// Double y:

// (2,1) → (2,2)

// GCD:

// gcd(2,2) = 2

// Double again:

// (2,2) → (4,2)

// GCD:

// gcd(4,2) = 2

// Again:

// (4,2) → (4,4)

// GCD:

// gcd(4,4) = 4

// So starting from GCD 1, doubling operations can create:

// 1 → 2 → 4 → 8 → 16 → ...

// They can only introduce factors of 2.

// They can never introduce a factor like:

// 3
// 5
// 7

// into the common GCD.

// 3. That's why target GCD must be a power of 2

// Suppose target is:

// (12,20)

// Then:

// gcd(12,20) = 4

// And:

// 4 = 2²

// That's possible.

// Now remove all factors of 2:

// 12 → 6 → 3
// 20 → 10 → 5

// We get:

// (3,5)

// Now:

// gcd(3,5) = 1

// That's what we're checking.

// 4. Why exactly gcd == 1?

// Because we've already removed every factor of 2 from both numbers.

// So whatever GCD remains cannot contain 2.

// Therefore, if the remaining GCD is:

// 1

// it means:

// There is no common factor left.

// So the original GCD contained only powers of 2.

// For example:

// Original GCD     After removing 2s
// ------------------------------------
// 1                1
// 2                1
// 4                1
// 8                1
// 16               1

// All are valid.

// But:

// 6 = 2 × 3
// 12 = 2 × 2 × 3

// After removing all 2s:

// 6 → 3
// 12 → 3

// and:

// gcd(3,3) = 3

// Not 1.

// That remaining 3 is an odd factor, which can never be created by our operations.

// Therefore impossible.