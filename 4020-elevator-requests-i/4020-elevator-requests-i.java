class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int m = requests.length;
        int sum = 0, last = 0;

        for(int i = 0 ; i < m ; i++){
            sum += Math.abs(requests[i] - last);
            last = requests[i];
        }

        return sum;
    }
}