class Solution{
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> list = new ArrayList<>();
        if(digits.length() == 0) return list;

        solve(0, digits, new StringBuilder(), map, list);
        return list;
    }

    public void solve(int ind, String s, StringBuilder sb, Map<Integer, String> map, List<String> list){
        if(ind == s.length()){
            list.add(sb.toString());
            return;
        }

        int c = s.charAt(ind) - '0';
        String w = map.get(c);

        for(int i = 0 ; i < w.length() ; i++){
            sb.append(w.charAt(i));

            solve(ind + 1, s, sb, map, list);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}



// class Solution {
//     public List<String> letterCombinations(String digits) {
//         HashMap<Integer, String> map = new HashMap<>();
//         map.put(2, "abc");
//         map.put(3, "def");
//         map.put(4, "ghi");
//         map.put(5, "jkl");
//         map.put(6, "mno");
//         map.put(7, "pqrs");
//         map.put(8, "tuv");
//         map.put(9, "wxyz");

//         List<String> result = new ArrayList<>();
//         if(digits.length() == 0) return result;

//         solve(digits, 0, map, new StringBuilder(), result);
//         return result;
//     }

//     public void solve(String s, int ind, HashMap<Integer, String> map, StringBuilder sb, List<String> result){

//         if(ind == s.length()){
//             result.add(sb.toString());
//             return;
//         }

//         int c = s.charAt(ind) - '0';
//         String letters = map.get(c);

//         for(int i = 0 ; i < letters.length() ; i++){

//             sb.append(letters.charAt(i));
//             solve(s, ind + 1, map, sb, result);
            
//             sb.deleteCharAt(sb.length() - 1);
//         }
//     }
// }
// //t.c = O(n.4^n) worst case
// //s.c = O(n.4^n)