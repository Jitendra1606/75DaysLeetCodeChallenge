class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;

        int last = -1;
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            if(forts[i] != 0){
                if(last != -1 && forts[i] != forts[last]){
                    max = Math.max(max, i - last - 1);
                }

                last = i;
            }
        }
        return max;
    } 
}