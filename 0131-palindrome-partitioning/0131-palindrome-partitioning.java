class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), result);
        return result;
    }
    public void solve(String s, int ind, List<String> list, List<List<String>> result){
        if(ind == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = ind; i < s.length() ; i++){
            if(isPalindrome(s, ind, i)){
                list.add(s.substring(ind, i + 1));
                solve(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int i , int j){
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}