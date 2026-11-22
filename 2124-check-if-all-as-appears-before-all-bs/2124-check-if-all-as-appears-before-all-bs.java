class Solution {
    public boolean checkString(String s) {
        boolean flag = true;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'b'){
                flag = false;
            }
            else if(flag == false && s.charAt(i) == 'a'){
                return false;
            }
        }

        return true;
    }
}