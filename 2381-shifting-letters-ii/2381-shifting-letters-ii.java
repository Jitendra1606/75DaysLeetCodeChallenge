class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int[] diff = new int[n + 1];
        for (int[] flight : shifts) {
            int start = flight[0];
            int end = flight[1];

            if (flight[2] == 0) {
                diff[start]--;
                diff[end + 1]++;
            } else {
                diff[start]++;
                diff[end + 1]--;
            }
        }
        //prefix sum
        for (int i = 1; i < n; i++) {
            diff[i] = diff[i] + diff[i - 1];
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int x = c - 'a';
            x = ((x + diff[i]) % 26 + 26) % 26;
            sb.append((char) (x + 'a'));
        }
        
        return sb.toString();
    }
}