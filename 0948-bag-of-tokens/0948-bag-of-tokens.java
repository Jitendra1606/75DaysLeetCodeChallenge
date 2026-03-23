class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length, max = 0;
        Arrays.sort(tokens);
        int i = 0, j = n - 1, cnt = 0;
        while(i <= j){
            if(tokens[i] <= power){
                power = power - tokens[i];
                cnt++;
                i++;
                max = Math.max(max, cnt);
            }else if(cnt > 0){
                    power = power + tokens[j];
                    cnt--;
                    j--;
            }else{
                break;
            }
        }
        return max;
    }
}