class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;

        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int oneCnt = map.getOrDefault(1L, 0);
        //ans is atleast the no. of occurences of 1, rounded down to an odd no.

        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;
        map.remove(1L);

        for (long num : map.keySet()) {
            int res = 0;
            long x = num;

            while (map.containsKey(x) && map.get(x) > 1) {
                res += 2;
                x *= x;
            }

            ans = Math.max(ans, res + (map.containsKey(x) ? 1 : -1));
        }
        return ans;
    }
}

// Why remove 1 from the map? map.remove(1L);
// Because the later logic assumes the numbers keep changing after squaring.
// For example, 2 -> 4 -> 16 -> ...
// But for 1, 1 -> 1 -> 1 -> 1
// The loop would never terminate. Look at the loop:

// while (map.containsKey(x) && map.get(x) > 1) {
//     res += 2;
//     x *= x;
// }

// If x = 1, x *= x;
// becomes : 1 *= 1; so, x = 1 forever :
// If there are at least two ones, map.get(1) > 1 : is always true, leading to an infinite loop.

// What happens if x = 1? Now suppose we start with 1.
// The sequence becomes
// 1 1 1 1 1 ...
// There are no different values. So if there are 7 ones, you can simply make
// 1 1 1 1 1 1 1, Length = 7.
// If there are 6 ones, you cannot use all 6 because the mountain length must be odd (there is exactly one center).
// So the best is,
// 1 1 1 1 1, Length = 5.
// That's exactly why the code does
// int oneCnt = map.getOrDefault(1L, 0);
// int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

// If the count is :
// 7 -> answer = 7
// 6 -> answer = 5
// 5 -> answer = 5
// 4 -> answer = 3
// 3 -> answer = 3
// 2 -> answer = 1
// 1 -> answer = 1
// It always keeps the largest odd number ≤ count.