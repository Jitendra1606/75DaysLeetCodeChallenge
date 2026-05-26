class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                arr1[ch - 'a'] = i;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                if(arr2[ch - 'A'] == -1){
                    arr2[ch - 'A'] = i;
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(arr1[i] != -1 && arr2[i] != -1){
                if(arr1[i] < arr2[i]) cnt++;
            }
        }
        return cnt;
    }
}