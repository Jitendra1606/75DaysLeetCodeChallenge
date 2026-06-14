class Solution {
    public long maxRatings(int[][] units) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        long sum = 0;

        for (int[] row : units) {
            Arrays.sort(row);
        }

        for (int i = 0; i < units.length; i++) {
            if (units[i].length == 1) {
                sum += units[i][0];
                continue;
            }

            if (units[i][0] < firstMin) {
                firstMin = units[i][0];
            }

            if (units[i][1] < secondMin) {
                secondMin = units[i][1];
            }

            sum += units[i][1];
        }

        return sum - secondMin + firstMin;
    }
}

// answer = global smallest first element + ∑(second smallest) − min(second smallest)
// This runs in O(m⋅nlogn) because of sorting each device.