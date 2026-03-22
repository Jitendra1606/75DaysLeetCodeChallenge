class Solution{
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return solve(s, 0, wordDict, dp);
    }
    public boolean solve(String s, int ind, List<String> str, Boolean[] dp){
        if(ind == s.length()) return true;
        if(dp[ind] != null) return dp[ind];
        for(int i = ind + 1 ; i <= s.length() ; i++){
            String split = s.substring(ind, i);
            if(str.contains(split) && solve(s, i, str, dp)) return dp[ind] = true;
        }
        return dp[ind] = false;
    }
}


// recursive sol tle at 38 / 45
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         return solve(s, 0, wordDict);
//     }
//     public boolean solve(String s, int ind, List<String> str){
//         if(ind == s.length()) return true;
//         for(int i = ind + 1; i <= s.length(); i++){
//             String split = s.substring(ind, i);
//             if(str.contains(split) && solve(s, i, str)) return true;
//         }
//         return false;
//     }
// }