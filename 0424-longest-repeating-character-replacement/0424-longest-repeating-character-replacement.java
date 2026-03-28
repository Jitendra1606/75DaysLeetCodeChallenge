class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int i = 0, j = 0, n = s.length(), max_freq = 0, max_len = 0;
        while(j < n){
            char ch = s.charAt(j);
            hash[ch - 'A']++;
            //first checking the highest frequency of any character, because in any window the replacement required is equal to the (total len - highest freq), so we keep track highest freq
            max_freq = Math.max(max_freq, hash[ch - 'A']);
            //in valid window we check for the longest substring
            if(j - i + 1 - max_freq <= k){
                max_len = Math.max(max_len, j - i + 1);
                j++;
            }else{
                //otherwise shrink the window
                hash[s.charAt(i) - 'A']--;
                i++;
                j++;
            }
        }
        return max_len;
    }
}