class Solution {
    public boolean checkStrings(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(i % 2 == 0){
                freq1[ch1 - 'a']++;
                freq1[ch2 - 'a']--;
            }else{
                freq2[ch1 - 'a']++;
                freq2[ch2 - 'a']--;
            }
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq1[i] != 0 || freq2[i] != 0) return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean checkStrings(String s1, String s2) {
//         if(s1.equals(s2)) return true;
//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];
//         for(int i = 0 ; i < s1.length() ; i++){
//             char ch = s1.charAt(i);
//             if(i % 2 == 0){
//                 freq1[ch - 'a']++;
//             }else{
//                 freq2[ch - 'a']++;
//             }
//         }
//         for(int i = 0 ; i < s2.length() ; i++){
//             char ch = s2.charAt(i);
//             if(i % 2 == 0){
//                 freq1[ch - 'a']--;
//             }else{
//                 freq2[ch - 'a']--;
//             }
//             if(freq1[ch - 'a'] < 0 || freq2[ch - 'a'] < 0){
//                 return false;
//             }
//         }
//         for(int i = 0 ; i < 26 ; i++){
//             if(freq1[i] != 0 || freq2[i] != 0) return false;
//         }
//         return true;
//     }
// }