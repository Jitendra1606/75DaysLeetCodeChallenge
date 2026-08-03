class Solution {
    public long countVowels(String word) {
        int n = word.length();

        long cnt = 0, ans = 0;

        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);

            if(isVowel(ch)){
                cnt++;

                ans += (long)(n - i) * (i + 1);
            }
        }
        return ans;
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}


// Suppose there is a vowel at index i.
// How many substrings include this character?

// Start can be chosen from 0 to i → i + 1 choices
// End can be chosen from i to n - 1 → n - i choices

// So this vowel appears in:

// (i+1)×(n−i)

// substrings.