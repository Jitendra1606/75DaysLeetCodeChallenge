class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();

        String str = "";

        //first convert each char into its correcponding binary representation of 8 length
        for(char c : s.toCharArray()){
            String binary = Integer.toBinaryString(c);

            while(binary.length() < 8){
                binary = "0" + binary;
            }

            str += binary;
        }

        //now we can simply check for palindrome

        int i = 0, j = str.length() - 1;

        while(i <= j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}