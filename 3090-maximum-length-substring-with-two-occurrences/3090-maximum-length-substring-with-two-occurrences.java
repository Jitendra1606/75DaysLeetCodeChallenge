class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        int[] arr = new int[26];

        int left = 0, right = 0, maxLen = 0;

        while(right < n){
            char ch = s.charAt(right);
            arr[ch - 'a']++;

            while(arr[ch - 'a'] > 2){
                arr[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}