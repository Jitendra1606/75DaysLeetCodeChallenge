class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;

        Arrays.sort(beans);

        long sum = 0;
        for(int num : beans){
            sum += num;
        }

        long ans = Long.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, sum - (1L * beans[i] * (n - i)));
        }

        return ans;
    }
}


// beans = [4, 1, 6, 5]

// Sort:

// beans = [1, 4, 5, 6]

// Total:

// total = 16

// Now try every beans[i] as the target.

// Target = 1
// i = 0
// target = 1

// All 4 bags remain:

// [1, 4, 5, 6]
//  ↓  ↓  ↓  ↓
// [1, 1, 1, 1]

// Beans kept:

// 1 × 4 = 4

// Beans removed:

// 16 - 4 = 12
// Target = 4
// i = 1
// target = 4

// Final:

// [0, 4, 4, 4]

// Beans kept:

// 4 × 3 = 12

// Beans removed:

// 16 - 12 = 4
// Target = 5
// i = 2
// target = 5

// Smaller bags:

// [1, 4]

// must become empty.

// Final:

// [0, 0, 5, 5]

// Beans kept:

// 5 × 2 = 10

// Beans removed:

// 16 - 10 = 6
// Target = 6
// i = 3
// target = 6

// Final:

// [0, 0, 0, 6]

// Beans kept:

// 6 × 1 = 6

// Beans removed:

// 16 - 6 = 10

// So:

// target     kept     removed

// 1          4        12
// 4          12       4    ← minimum
// 5          10       6
// 6          6        10

// Answer:

// 4