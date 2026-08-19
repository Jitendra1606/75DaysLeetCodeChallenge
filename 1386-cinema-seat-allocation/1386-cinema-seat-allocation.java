//we have only 3 possibilities in total, left, right or middle and we have given our range 2 - 9, so we can use only these 8 bits to check 

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int midd = 0b11000011;
        int righ = 0b00001111;

        Map<Integer, Integer> map = new HashMap<>();
        //creating a map, and putting bitmask value according to row

        for (int[] seat : reservedSeats) {
            //if seat[1]=1 & = 10, then it means we can use all the seats b/w them
            if (seat[1] >= 2 && seat[1] <= 9) {

                int origin = map.containsKey(seat[0]) ? map.get(seat[0]) : 0;

                //if a row is already accessed, and later a new seat come for that particular row, so we need to preserve the previous allocation status also, that's why we are doing OR, and i - 2, to reduce 10 size to size 8

                int value = origin | (1 << (seat[1] - 2));

                map.put(seat[0], value);
            }
        }

        //if row has no seat lie b/w 2 - 9, then it'll give us 2 cnt, that's why
        int ans = (n - (map.size())) * 2;

        //simply accessing map & checking if OR with our left, mid, right is equal to our calculated ones or not
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int row = entry.getKey(), bitmask = entry.getValue();

            if ((bitmask | left) == left || (bitmask | righ) == righ || (bitmask | midd) == midd)
                ++ans;
        }

        return ans;
    }
}


// 2. Why OR?

// Suppose row 1 already has seat 2 occupied.

// origin = 00000001

// Now we encounter seat 5.

// 1 << (5 - 2)
// = 1 << 3
// = 00001000

// Then:

// value = origin | (1 << (seat[1] - 2));

// becomes:

//   00000001   // seat 2 already occupied
// | 00001000   // mark seat 5 occupied
// -----------
//   00001001   // seats 2 and 5 occupied

// So OR basically means:

// Keep all previously occupied seats AND mark this new seat as occupied.