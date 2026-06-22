class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }
            if (low < 0)
                low = 0;
            if (high < 0)
                return false;
        }
        return low == 0;
    }
}

// low = minimum possible number of unmatched '('
// high = maximum possible number of unmatched '('

// Think of low and high as:

// low  = best case (fewest unmatched '(')
// high = worst case (most unmatched '(')

// For '*':

// Treat as ')' -> low decreases
// Treat as '(' -> high increases