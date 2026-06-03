class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
//just treat matrix as a histogram chart and increase the length of bars as we go down the matrix and we will only maintain a single array of sixe n to keep track of the heights of histogram bars
        int[] height = new int[m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] - '0' == 1) height[j]++;
                else height[j] = 0;
            }
            int area = histogram(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int histogram(int[] height){
        int n = height.length;

        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        //NSR:NEXT SMALLER TO RIGHT
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st1.isEmpty() && height[st1.peek()] >= height[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = st1.peek();
            }
            st1.push(i);
        }

        //NSL:NEXT SMALLER TO LEFT
        for(int i = 0 ; i < n ; i++){
            while(!st2.isEmpty() && height[st2.peek()] >= height[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = st2.peek();
            }
            st2.push(i);
        }

        int max = 0;
        for(int i = 0 ; i < n ; i++){
            int width = nsr[i] - nsl[i] - 1;
            max = Math.max(max, height[i] * width);
        }
        return max;
    }
}