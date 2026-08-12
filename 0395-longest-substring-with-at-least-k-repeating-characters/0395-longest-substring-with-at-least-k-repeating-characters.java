class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for(int uni = 1 ; uni <= 26 ; uni++){
            int[] charFreq = new int[26];

            int uniqueChar = 0;
            int kFreq = 0;

            int left = 0, right = 0;

            while(right < n){

                char curr = s.charAt(right);

                if(charFreq[curr - 'a'] == 0) uniqueChar++;

                if(charFreq[curr - 'a'] == k - 1) kFreq++;

                charFreq[curr - 'a']++;

                while(uniqueChar > uni){

                    char leftchar = s.charAt(left);

                    if(charFreq[leftchar - 'a'] == 1) uniqueChar--;

                    if(charFreq[leftchar - 'a'] == k) kFreq--;

                    charFreq[leftchar - 'a']--;
                    left++;
                }

                if(uniqueChar == uni && kFreq == uniqueChar){
                    maxLen = Math.max(maxLen, right - left + 1);
                }

                right++;
            }
        }
        return maxLen;
    }
}