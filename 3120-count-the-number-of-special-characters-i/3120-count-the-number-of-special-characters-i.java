class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                arr1[ch - 'a']++;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                arr2[ch - 'A']++;
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(arr1[i] != 0 && arr2[i] != 0) cnt++;
        }

        return cnt;
    }
}