class Solution {
    public boolean canReach(int[] start, int[] target) {
        // int x = start[0];
        // int y = start[1];

        // int x1 = target[0];
        // int y1 = target[1];

        // if(((x + y) % 2 == 0 && (x1 + y1) % 2 == 0) || (((x1 + y1) % 2 == 1) && (x + y) % 2 == 1)) return true;

        // return false;

        int st = (start[0] + start[1]) % 2;
        int ta = (target[0] + target[1]) % 2;

        return (st == ta);
    }
}