//actually we can't generate the whole string here as the constraints are very high so we can give our with the help of length 

class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        long len = 0;

        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);

            if(c == '*'){
                if(len > 0) len--;
            }
            else if(c == '#'){
                len *= 2;
            }
            else if(c == '%'){
                continue;
            }
            else if(c != '*' && c != '#' && c != '%'){
                len++;
            }
        }
        if(k >= len) return '.';

        for(int i = n - 1 ; i >= 0 ; i--){
            char ch = s.charAt(i);

            if(ch == '*') len++; //no change in k

            else if(ch == '#'){
                len = len / 2;
                k = (k >= len) ? k - len : k;
            }
            else if(ch == '%'){
                k = len - k - 1;
            }
            else{
                len--;
            }

            if(len == k) return ch;
        }
        return '.';
    }
}