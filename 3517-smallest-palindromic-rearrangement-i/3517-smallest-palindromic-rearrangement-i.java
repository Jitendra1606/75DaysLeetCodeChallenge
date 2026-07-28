class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n < 4) return s;

        int[] hash = new int[26];

        for(int i = 0 ; i < n ; i++){
            hash[s.charAt(i) - 'a']++;
        }


        char[] ans = new char[n];

        int left = 0, right = n - 1;

        for(int i = 0 ; i < 26 ; i++){

            while(hash[i] >= 2){
                ans[left] = (char)(i + 'a');
                ans[right] = (char)(i + 'a');
                hash[i] = hash[i] - 2; //is cond ki wjh se upr wali cond 0 ho jayegi nhi to out of bnd jayegi, fir chahe vo odd no. hi kyu na ho

                left++;
                right--; 
            }
        }

        for(int i = 0 ; i < 26 ; i++){
            if(hash[i] == 1){
                ans[n / 2] = (char)(i + 'a');
                break;
            }
        }

        return new String(ans);
    }
}