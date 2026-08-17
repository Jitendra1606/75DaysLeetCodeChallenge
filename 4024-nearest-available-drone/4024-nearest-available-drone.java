class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int min = Integer.MAX_VALUE, ind = -1;

        for (int i = 0; i < n; i++) {
            int st = drones[i][0];
            int en = drones[i][1];
            int val = drones[i][2];

            int dis = Math.abs(target[0] - st) + Math.abs(target[1] - en);

            if (dis <= val && dis < min) {
                min = dis;
                ind = i;
            }
        }
        return ind;
    }
}