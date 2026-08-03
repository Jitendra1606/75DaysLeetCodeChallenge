class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int leftSum = 0, rightSum = 0, maxSum = 0;

        for(int i = 0 ; i < k ; i++){
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;
        int right = n - 1;
        for(int i = k - 1 ; i >= 0 ; i--){
            leftSum = leftSum - cardPoints[i];

            rightSum += cardPoints[right];
            right--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}