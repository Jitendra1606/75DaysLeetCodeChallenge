class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        boolean upper = true;
        boolean lower = true;

        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                upper = false;
            }
            if(ch >= 'A' && ch <= 'Z'){
                lower = false;
            }
        }

        // Case 1: all uppercase OR all lowercase
        if(upper || lower) return true;

        // Case 2: First uppercase, rest lowercase
        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            for(int i = 1; i < n; i++){
                char ch = word.charAt(i);
                if(ch < 'a' || ch > 'z') return false;
            }
            return true;
        }

        return false;
    }
}