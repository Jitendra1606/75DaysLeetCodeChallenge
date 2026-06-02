class Solution{
    public int minCut(String s){
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n, s, dp) - 1;
    }

    public int solve(int i, int n, String s, int[] dp){
        if(i == n) return 0;
        int min = Integer.MAX_VALUE;

        if(dp[i] != -1) return dp[i];

        for(int j = i ; j < n ; j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + solve(j + 1, n, s, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}






// class Solution{
//     public int minCut(String s){
//         int n = s.length();
//         return solve(0, n, s) - 1;
//     }

//     public int solve(int i, int n, String s){
//         if(i == n) return 0;
//         int min = Integer.MAX_VALUE;

//         for(int j = i ; j < n ; j++){
//             if(isPalindrome(i, j, s)){
//                 int cost = 1 + solve(j + 1, n, s);
//                 min = Math.min(min, cost);
//             }
//         }
//         return min;
//     }

//     public boolean isPalindrome(int i, int j, String s){
//         while(i < j){
//             if(s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }
