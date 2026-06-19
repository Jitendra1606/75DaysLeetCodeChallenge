class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        Integer[][] dp = new Integer[n][n];

        return solve(0, n - 1, s, dp);
    }

    public int solve(int i, int j, String s, Integer[][] dp){
        if(i > j) return 0;

        if(i == j) return 1;

        if(dp[i][j] != null) return dp[i][j];

        int ans = 1 + solve(i, j - 1, s, dp);

        for(int k = i ; k < j ; k++){
            if(s.charAt(k) == s.charAt(j)){
                ans = Math.min(ans, solve(i, k, s, dp) + solve(k + 1, j - 1, s, dp));
            }
        }
        return dp[i][j] = ans;
    }
}

// Why this formula?

// Suppose:

// a b c a
//       ^
//       j

// and

// k = 0

// Both are 'a'.

// Then:

// Left Part
// solve(i,k)

// prints everything up to the first 'a'.

// Middle Part
// solve(k+1,j-1)

// prints the stuff between them.

// The last 'a' gets merged with the first 'a' printing operation.

// Therefore no extra cost for position j.