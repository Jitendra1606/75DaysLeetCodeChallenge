//isme phle given string ko 2d array pr map krdo fir wha se direct add krdo rowwise
//aur 2d array m map krne ke liye hme zigzag pattern hi follow krna h,
//phle row ko bdhao fir jb (row-1) pr phuch jao fir km krte huye upar bdho aur neeche aao

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;

        List<Character>[] rows = new ArrayList[numRows];
        for(int i = 0 ; i < numRows ; i++){
            rows[i] = new ArrayList<>();
        }

        int ind = 0, d = 1;
        for(char c : s.toCharArray()){
            rows[ind].add(c);

            if(ind == 0) d = 1;
            else if(ind == numRows - 1) d = -1;

            ind += d;
        }
        
        StringBuilder sb = new StringBuilder();
        for(List<Character> row : rows){
            for(char ch : row){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}