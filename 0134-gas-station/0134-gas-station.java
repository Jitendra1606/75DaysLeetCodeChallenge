class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int ans = 0;
        int currGain = 0;
        int totGain = 0;

        for(int i = 0 ; i < n ; i++){

            int gain = gas[i] - cost[i];
            currGain += gain;
            totGain += gain;

            if(currGain < 0){
                ans = i + 1;
                currGain = 0;
            }
        }

        return (totGain >= 0) ? ans : -1;
    }
}