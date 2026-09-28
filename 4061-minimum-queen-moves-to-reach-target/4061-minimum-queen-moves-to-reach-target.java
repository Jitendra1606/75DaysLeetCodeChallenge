class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int stx = source[0];
        int ste = source[1];
        int tax = target[0];
        int tae = target[1];

        if (stx == tax && ste == tae)
            return 0;
        else if (ste == tae || stx == tax || (Math.abs(stx - tax) == Math.abs(ste - tae)))
            return 1;
        return 2;
    }
}