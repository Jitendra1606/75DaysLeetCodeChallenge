class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cntL = 0;
        int cntR = 0, cnt = 0;
        int n = moves.length();
        for(int i = 0 ; i < n ; i++){
            if(moves.charAt(i) == 'L'){
                cntL++;
            }else if(moves.charAt(i) == 'R'){
                cntR++;
            }else{
                cnt++;
            }
        }
        if(cntL > cntR){
            return cntL + cnt - cntR;
        }else{
            return cntR + cnt - cntL;
        }
    }
}