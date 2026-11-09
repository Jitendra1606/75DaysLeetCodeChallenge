class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();

        int i = 0, n = s1.length(); //both strings are of same length

        while(i < n){
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
                continue;   //notinh to do
            }

            int start = i;  //from where our mismatched string starts

            while(i < n && s1.charAt(i) != s2.charAt(i)){ //till string matches
                i++;
            } 

            String sub1 = s1.substring(start, i); //extracting substring of mismatched portion
            String sub2 = s2.substring(start, i); 

            res.add(Arrays.asList(sub1, sub2)); //adding in list
        }

        return res;
    }
}