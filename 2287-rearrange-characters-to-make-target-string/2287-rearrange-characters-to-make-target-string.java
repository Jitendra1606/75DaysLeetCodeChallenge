class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] hash = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            hash[c - 'a']++;
        }

        int[] hash2 = new int[26];

        for(int i = 0 ; i < target.length() ; i++){
            char c = target.charAt(i);
            hash2[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < 26 ; i++){
            if(hash2[i] > 0){
                ans = Math.min(ans, hash[i] / hash2[i]);
            }
        }
        return ans;
    }
}