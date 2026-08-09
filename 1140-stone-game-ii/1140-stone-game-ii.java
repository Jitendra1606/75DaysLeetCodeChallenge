class Solution{
    int[][][] dp = new int[2][102][102];
    public int stoneGameII(int[] piles){
        int n = piles.length;

        for(int[][] arr2d : dp){
            for(int[] arr1d : arr2d){
                Arrays.fill(arr1d, -1);
            }
        }

        return solveForAlice(piles, 1, 0, 1);
    }

    public int solveForAlice(int[] piles, int person, int i, int M){
        int n = piles.length;
        if(i >= n) return 0;

        if(dp[person][i][M] != -1) return dp[person][i][M];

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int x = 1 ; x <= Math.min(2 * M, n - i
        ) ; x++){
            stones += piles[i + x - 1];

            if(person == 1){
                result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x)));
            }else{
                result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x)));
            }
        }
        return dp[person][i][M] = result;
    }
}



// class Solution {
//     int n;
//     int[] suffixSum;
//     Integer[][] dp;
//     public int stoneGameII(int[] piles) {
//         n = piles.length;

//         //suffix sum
//         suffixSum = new int[n];

//         suffixSum[n - 1] = piles[n - 1];
//         for(int i = n - 2 ; i >= 0 ; i--){
//             suffixSum[i] = suffixSum[i + 1] + piles[i];
//         }

//         dp = new Integer[n][n + 1];
        
//         return solve(0, 1);
//     }

//     public int solve(int i, int M){
//         if(i >= n) return 0; //no piles left

//         if(i + 2 * M >= n) return suffixSum[i];

//         if(dp[i][M] != null) return dp[i][M];

//         int maxStones = 0;

//         for(int x = 1 ; x <= 2 * M ; x++){
//             int opponent = solve(i + x, Math.max(M, x));

//             maxStones = Math.max(maxStones, suffixSum[i] - opponent);
//         }
//         return dp[i][M] = maxStones;
//     }
// }