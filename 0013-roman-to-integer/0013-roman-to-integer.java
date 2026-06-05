class Solution {
    public int romanToInt(String s) {
        int n = s.length();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'I') {
                if (i + 1 < n && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V')) {
                    sum += -1;
                } else {
                    sum += 1;
                }
            } else if (ch == 'V') {
                sum += 5;
            } else if (ch == 'X') {
                if (i + 1 < n && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    sum += -10;
                } else {
                    sum += 10;
                }
            } else if (ch == 'L') {
                sum += 50;
            } else if (ch == 'C') {
                if (i + 1 < n && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    sum += -100;
                } else {
                    sum += 100;
                }
            } else if (ch == 'D') {
                sum += 500;
            } else if (ch == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
}