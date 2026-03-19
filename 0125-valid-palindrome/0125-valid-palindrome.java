class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            //if it is not the character then shrink the size from front
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }//if it is not character then shrink the size from behind
            else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }//to check palindrome while converting upper to lower case as well
            else if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                //for whitespaces
                start++;
                end--;
            }
        }
        return true;
    }
}