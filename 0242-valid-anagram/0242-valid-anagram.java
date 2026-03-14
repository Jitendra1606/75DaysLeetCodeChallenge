class Solution{
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < 26; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
}


// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
//         char[] s1 = s.toCharArray();
//         char[] s2 = t.toCharArray();
//         Arrays.sort(s1);
//         Arrays.sort(s2);
//         for(int i = 0 ; i < s.length() ; i++){
//             if(s1[i] != s2[i]) return false;
//         }
//         return true;
//     }
// }