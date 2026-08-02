class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int left = 0, right = 0, min = Integer.MAX_VALUE, cnt = 0;

        while(right < n){
            char ch = blocks.charAt(right);

            if(ch == 'W') cnt++;

            if(right - left + 1 > k){
                if(blocks.charAt(left) == 'W') cnt--;

                left++;
            }

            if(right - left + 1 == k){
                min = Math.min(min, cnt);
            }

            right++;
        }
        return min;
    }
}