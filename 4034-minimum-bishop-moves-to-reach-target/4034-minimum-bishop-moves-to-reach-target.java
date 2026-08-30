class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int diff1 = Math.abs(source[0] - source[1]);
        int diff2 = Math.abs(target[0] - target[1]);

        if ((diff1 % 2) != (diff2 % 2))
            return -1;

        if ((Math.abs(target[0] - source[0])) == (Math.abs(target[1] - source[1])))
            return 1;
        return 2;
    }
}