class Solution{
    public int lengthOfLongestSubstring(String s){
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int n = s.length(), max = 0;
        int i = 0, j = 0;
        while(j < n){
            if(hash[s.charAt(j)] != -1){
                if(hash[s.charAt(j)] >= i){
                    i = hash[s.charAt(j)] + 1;
//basic idea behind this -->
// If we have already seen the character then we need to shrink our window
// and to shrink the window we need to delete that repeating character from our window
// so we make a jump s.charAt(j) means that repeating character
// so by adding +1 to this in i our window shrinks and does not contains that character now
                }
            }
            max = Math.max(max, j - i + 1);
            hash[s.charAt(j)] = j;
            j++;
        }
        return max;
    }
}


//not optimal with respect to space bcz we are using hashset here
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> set = new HashSet<>();
//         int max = 0, n = s.length();
//         int i = 0, j = 0;
//         while(j < n){
//             if(!set.contains(s.charAt(j))){
//                 set.add(s.charAt(j));
//                 max = Math.max(max, j - i + 1);
//                 j++;
//             }else{
//                 set.remove(s.charAt(i));
//                 i++;
//             }
//         }
//         return max;
//     }
// }