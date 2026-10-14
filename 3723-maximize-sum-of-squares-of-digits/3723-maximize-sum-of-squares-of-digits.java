class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";

        int rem = sum % 9;

        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;

        for(int i = 0 ; i < nines ; i++){
            sb.append('9');
        }

        if(rem > 0) sb.append((char)('0' + rem));

        int zero = num - sb.length();
        for(int i = 0 ; i < zero ; i++){
            sb.append('0');
        }
        
        return sb.toString();
    }
}