class Solution{
    public int findContentChildren(int[] g, int[] s){
        int n = g.length, m = s.length;
        
        Arrays.sort(g);
        Arrays.sort(s);

        return solve(0, 0, n, m, g, s);
    }

    public int solve(int i, int j, int n, int m, int[] g, int[] s){
        if(i >= n || j >= m) return 0;

        if(s[j] >= g[i]){
            return 1 + solve(i + 1, j + 1, n, m, g, s);
        }
        return solve(i, j + 1, n, m, g, s);
    }
}



// class Solution{
//     public int findContentChildren(int[] g, int[] s){
        
//         Arrays.sort(g);
//         Arrays.sort(s);
        
//         int n1 = g.length, n2 = s.length;

//         int[][] dp = new int[n1 + 1][n2 + 1];
//         for(int[] row : dp) Arrays.fill(row, -1);
        
//         return solve(0, 0, n1, n2, g, s, dp);
//     }

//     public int solve(int i, int j, int n, int m, int[] g, int[] s, int[][] dp){
        
//         if(j >= m || i >= n) return 0;

//         if(dp[i][j] != -1) return dp[i][j]; 

//         if(s[j] >= g[i]){
//             return dp[i][j] = 1 + solve(i + 1, j + 1, n, m, g, s, dp);
//         }
//         return dp[i][j] = solve(i, j + 1, n, m, g, s, dp);
//     }
// }
//t.c = O(n1 log n1 + n2 log n2)
//s.c = O(n1 * n2)


// class Solution{
//     public int findContentChildren(int[] g, int[] s){
        
//         Arrays.sort(g);
//         Arrays.sort(s);
        
//         int n1 = g.length, n2 = s.length;
        
//         return solve(0, 0, n1, n2, g, s);
//     }

//     public int solve(int i, int j, int n, int m, int[] g, int[] s){
        
//         if(j >= m || i >= n) return 0;

//         if(s[j] >= g[i]){
//             return 1 + solve(i + 1, j + 1, n, m, g, s);
//         }
//         return solve(i, j + 1, n, m, g, s);
//     }
// }
//t.c = O(n1 log n1 + n2 log n2)
//s.c = O(m) ,Recursive stack depth


// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         if(s.length == 0) return 0;
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int i = 0, j = 0, cnt = 0;
//         while((i < g.length) && (j < s.length)){
//             if(s[j] >= g[i]){
//                 cnt++;
//                 i++;
//                 j++;
//             }else{
//                 j++;
//             }
//         }
//         return cnt;
//     }
// }
//tc = O(nlogn + mlogm)
//sc = O(1)