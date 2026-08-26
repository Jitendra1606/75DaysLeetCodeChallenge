class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int right = 0, left = 0, one = 0, min = Integer.MAX_VALUE;

        StringBuilder sb = new StringBuilder();

        while (right < n) {
            char ch = s.charAt(right);

            if (ch == '1')
                one++;

            while (one > k) {
                if (s.charAt(left) == '1') {
                    one--;
                }
                left++;
            }

            if (one == k) {

                while(left < right && s.charAt(left) == '0') left++;

                int len = right - left + 1;
                
                String cand = s.substring(left, right + 1);

//comparing for lexicographically smaller string
                if (len < min || (len == min && cand.compareTo(sb.toString()) < 0)) {
                    
                    min = len;
                    
                    sb.setLength(0);

                    sb.append(cand);
                }
            }

            right++;
        }
        return sb.toString();
    }
}

// For:

// a.compareTo(b)
// Result	Meaning
// < 0	a comes before b
// == 0	a and b are equal
// > 0	a comes after b

// For example:

// "011".compareTo("101") < 0   // true
// "101".compareTo("011") > 0   // true
// "101".compareTo("101") == 0  // true