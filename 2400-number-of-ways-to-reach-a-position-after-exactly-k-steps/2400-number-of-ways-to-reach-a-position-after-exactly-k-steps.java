class Solution{
    static final int MOD = 1_000_000_007;
    Long[][] dp;

    public int numberOfWays(int startPos, int endPos, int k){
        int dis = endPos - startPos;

        if(Math.abs(dis) > k) return 0;

        if((k - Math.abs(dis)) % 2 != 0) return 0;

        int right = (k + dis) / 2;
        
        dp = new Long[k + 1][right + 1];
        
        return (int)combinations(k, right);
    }

    public long combinations(int n, int r){
        if(r == 0 || r == n) return 1;

        if(dp[n][r] != null) return dp[n][r];

        return dp[n][r] = (combinations(n - 1, r - 1) + combinations(n - 1, r)) % MOD;
    }
}


// class Solution {
//     public int numberOfWays(int startPos, int endPos, int k) {
//         int MOD = 1_000_000_007;

//         int dis = Math.abs(endPos - startPos);

//         //if dis > k
//         if(dis > k) return 0;

//         //remaining steps must be pairs, R + L or L + R
//         if((k - dis) % 2 != 0) return 0;

//         int right = (k + endPos - startPos) / 2;

//         long[][] dp = new long[k + 1][k + 1];

//         dp[0][0] = 1;

//         for(int i = 1 ; i <= k ; i++){
//             dp[i][0] = 1;

//             for(int j = 1 ; j <= i ; j++){
//                 dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
//             }
//         }
//         return (int)dp[k][right];
//     }
// }

//explaination
// This problem is a very good example of "convert the movement problem into a counting problem."

// The key is to forget the actual positions for a moment and ask:

// In k steps, how many times must I move right and how many times must I move left?

// 1. Understand the movement

// Every step is either:

// Right = +1
// Left  = -1

// Suppose:

// startPos = 1
// endPos = 2
// k = 3

// We need a net movement of +1:

// endPos - startPos
// = 2 - 1
// = 1

// Let:

// R = number of right steps
// L = number of left steps

// Since we take exactly k steps:

// R + L = k

// And because right is +1 and left is -1:

// R - L = endPos - startPos

// So we have two equations.

// 2. Solve the equations

// Let:

// distance = endPos - startPos

// Then:

// R + L = k
// R - L = distance

// Add them:

// 2R = k + distance

// Therefore:

// R = (k + distance) / 2

// Similarly:

// L = (k - distance) / 2
// 3. Example
// startPos = 1
// endPos = 2
// k = 3

// Distance:

// distance = 2 - 1 = 1

// Therefore:

// R = (3 + 1) / 2
//   = 2

// L = (3 - 1) / 2
//   = 1

// So we need:

// 2 Right
// 1 Left

// Now the question becomes:

// How many different orders can I arrange 2 R's and 1 L?

// They are:

// R R L
// R L R
// L R R

// Therefore:

// answer = 3

// Exactly the example.

// 4. So this is just a combination

// If we have:

// R = 2
// L = 1

// Total steps:

// R + L = 3

// We need to choose which R positions among the 3 steps are right movements:

// C(3,2)

// or equivalently:

// C(3,1)

// Therefore:

// answer = C(k, R)

// So the whole problem becomes:

// answer = C(k, (k + endPos - startPos) / 2)

// provided the required number of left/right steps is valid.

// 5. When is it impossible?

// There are two important conditions.

// Condition 1: Distance cannot exceed k

// Suppose:

// start = 2
// end = 10
// k = 5

// Distance:

// 8

// But you only have 5 steps.

// Impossible.

// So:

// Math.abs(endPos - startPos) > k

// means:

// answer = 0
// 6. Condition 2: Parity must match

// This is the more important one.

// Suppose:

// start = 2
// end = 5
// k = 10

// Distance:

// 3

// We need:

// R = (10 + 3) / 2
//   = 13 / 2

// Not an integer.

// Therefore impossible.

// Another way to see it:

// Every pair of extra movements:

// Right + Left

// adds 2 steps but brings you back to the same position.

// So if you need to cover distance 3, the number of steps must have the same parity as 3.

// distance = 3

// possible steps:
// 3, 5, 7, 9, 11, ...

// But 10 isn't one of them.

// Therefore:

// if ((k - Math.abs(endPos - startPos)) % 2 != 0)
//     return 0;
// 7. Complete mathematical solution

// Since:

// k <= 1000

// we can easily calculate combinations using DP.

// Define:

// dp[i][j] = C(i,j)

// Pascal's Triangle:

// C(n,k) = C(n-1,k-1) + C(n-1,k)

// So:

// class Solution {
//     public int numberOfWays(int startPos, int endPos, int k) {

//         int MOD = 1_000_000_007;

//         int distance = Math.abs(endPos - startPos);

//         // Can't cover the distance in k steps
//         if (distance > k)
//             return 0;

//         // Remaining steps must be pairs:
//         // Right + Left or Left + Right
//         if ((k - distance) % 2 != 0)
//             return 0;

//         int right = (k + endPos - startPos) / 2;

//         long[][] dp = new long[k + 1][k + 1];

//         dp[0][0] = 1;

//         for (int i = 1; i <= k; i++) {

//             dp[i][0] = 1;

//             for (int j = 1; j <= i; j++) {

//                 dp[i][j] =
//                     (dp[i - 1][j - 1] + dp[i - 1][j])
//                     % MOD;
//             }
//         }

//         return (int) dp[k][right];
//     }
// }
// 8. But there's an even simpler DP

// Because k <= 1000, we can directly think:

// dp[step][position]

// But positions can be negative, so we'd need an offset.

// For example:

// dp[i][j] = number of ways to reach position j
//            after i steps

// Transition:

// dp[i][j] =
//     dp[i-1][j-1]
//   + dp[i-1][j+1]

// That works, but it's unnecessarily complicated.

// The combination approach is much cleaner.

// 9. Let's understand the formula deeply

// This is the main thing I want you to take away.

// You have:

// k steps

// and each step is either:

// +1
// -1

// Suppose the net displacement is:

// D = endPos - startPos

// Then:

// R - L = D
// R + L = k

// From these:

//         k + D
// R = -----------
//            2

//         k - D
// L = -----------
//            2

// Then:

// number of ways = C(k,R)

// because we only need to decide which R positions are right steps.

// 10. Example 2
// startPos = 2
// endPos = 5
// k = 10

// We need:

// D = 3

// Therefore:

// R = (10 + 3) / 2
//   = 6.5

// Not possible.

// So:

// answer = 0

// No need to do any DP.

// 11. Example with a valid larger case

// Suppose:

// start = 1
// end = 4
// k = 5

// Distance:

// D = 3

// We need:

// R = (5 + 3) / 2
//   = 4

// L = (5 - 3) / 2
//   = 1

// So we need:

// R R R R L

// in any order.

// Number of ways:

// C(5,4)
// = 5

// The five sequences are:

// L R R R R
// R L R R R
// R R L R R
// R R R L R
// R R R R L

// All finish at position 4.

// ⭐ Pattern to recognize

// This problem is not really a DP problem.

// It's fundamentally:

// Movement
//    ↓
// Count Right / Left
//    ↓
// Solve two equations
//    ↓
// Combination
//    ↓
// C(k, right)

// And the two early checks are:

// if (distance > k)
//     return 0;

// if ((k - distance) % 2 != 0)
//     return 0;

// Then:

// right = (k + endPos - startPos) / 2;
// answer = C(k, right);

// This is a really useful interview pattern: when every operation contributes +1/-1, try converting the problem into counting how many +1 and -1 operations are required.

// 6. Condition 2: Parity must match This is the more important one. Suppose:

// i did n't get this part

// Yes — parity is probably the confusing part. Let's understand it without formulas first.

// What does parity mean?

// Parity simply means:

// Even → 2, 4, 6, 8, 10...
// Odd → 1, 3, 5, 7, 9...

// In this problem, the important thing is:

// The distance between start and end must have the same parity as k.

// Why?

// Look at what one step does

// Every step is either:

// Right → +1
// Left  → -1

// Suppose you start at 0.

// After 1 step

// You can be:

// -1 or +1

// Both are odd.

// After 2 steps

// Possible positions:

// -2, 0, 2

// All are even.

// After 3 steps

// Possible positions:

// -3, -1, 1, 3

// All are odd.

// After 4 steps

// Possible positions:

// -4, -2, 0, 2, 4

// All are even.

// See the pattern?

// steps     possible displacement
// --------------------------------
// 1         odd
// 2         even
// 3         odd
// 4         even
// 5         odd

// So:

// After an odd number of steps, displacement must be odd.

// After an even number of steps, displacement must be even.

// That's the parity condition.

// Now your example
// startPos = 2
// endPos = 5
// k = 10

// The required displacement is:

// 5 - 2 = 3

// So we need to move 3 positions to the right overall.

// But:

// distance = 3 → ODD
// k = 10 → EVEN

// They don't have the same parity.

// Therefore it's impossible.

// But WHY can't we do it?

// Let's try.

// To move from 2 to 5, we need a net movement of:

// +3

// Suppose we take only right steps:

// 2 → 3 → 4 → 5

// That's 3 steps.

// But we need exactly 10 steps.

// We have:

// 10 - 3 = 7

// extra steps.

// Can we waste 7 steps and still finish at 5?

// No.

// Why?

// Because to waste movement without changing the final position, we need pairs:

// Right + Left

// For example:

// 5 → 6 → 5

// That's 2 extra steps.

// So extra steps must come in:

// 2, 4, 6, 8, 10...

// But we have:

// 7 extra steps

// which is impossible.

// That's the easiest way to understand parity.

// Compare with a possible case

// Suppose:

// start = 2
// end = 5
// k = 9

// Distance:

// 5 - 2 = 3

// We need at least 3 steps:

// 2 → 3 → 4 → 5

// We have:

// 9 - 3 = 6

// extra steps.

// 6 is even, so we can waste them in pairs:

// 2 → 3 → 4 → 5 → 6 → 5 → 4 → 5 → 4 → 5

// That's 9 steps and ends at 5.

// So:

// distance = 3  → odd
// k = 9          → odd

// Same parity → possible.

// Connect this to the formula

// We said:

// R + L = k

// and:

// R - L = distance

// Adding them:

// 2R = k + distance

// Therefore:

// R = (k + distance) / 2

// Now R has to be a whole number.

// So:

// k + distance

// must be even.

// That happens exactly when k and distance have the same parity.

// Same parity:
// even + even = even
// odd  + odd  = even
// Different parity:
// even + odd = odd
// odd + even = odd

// And we can't have:

// R = 13 / 2 = 6.5

// because we can't take 6.5 right steps.

// So remember this simple rule

// For this problem:

// distance = abs(endPos - startPos)

// Then:

// if distance > k
//     impossible

// if (k - distance) is odd
//     impossible

// or equivalently:

// if ((k - distance) % 2 != 0)
//     return 0;
// Why k - distance?

// Because:

// distance = minimum steps needed

// and every extra pair of steps looks like:

// +1, -1

// or:

// -1, +1

// which adds 2 steps without changing the final position.

// So the number of extra steps must be even.

// That's the whole parity idea.