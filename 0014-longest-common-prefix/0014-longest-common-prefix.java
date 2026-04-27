class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return " ";//case when array is empty
        }
        StringBuilder sb = new StringBuilder();
        String first = strs[0];//initializing with first element of str array

        for(int i = 0 ; i < first.length() ; i++){
            char ch = first.charAt(i);//we'll compare other elements with first element(eg:- flower, is our first element here) only
            for(int j = 1 ; j < strs.length ; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){ //if any element is greater in size or character not equal then stop the loop
                    return sb.toString();
                }
            }
            sb.append(ch); //if characters matching append it in StringBuilder
        }
        return sb.toString();
    }
}
//Time complexity-- O(N * M)