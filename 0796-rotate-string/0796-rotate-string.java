// class Solution{
//     public boolean rotateString(String s, String goal){
//         if(s == null || goal == null) return false;
//         if(s.length() != goal.length()) return false;
//         if((s + s).contains(goal)) return true;
//         return false;
//     }
// }

class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;

        char[] st = s.toCharArray();

        for(int i = 0 ; i < st.length ; i++){
            shift(st);
            String stt = new String(st);
            if(stt.equals(goal)) return true;
        }
        return false;
    }
    public void shift(char[] s){
        char temp = s[0];
        for(int i = 1 ; i < s.length ; i++){
            s[i - 1] = s[i];
        }
        s[s.length - 1] = temp;
    }
}