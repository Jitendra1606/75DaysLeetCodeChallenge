class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
       int[] nsr = new int[n];
       int[] nsl = new int[n];
       int[] width = new int[n];
       Stack<Integer> s1 = new Stack<>();
       Stack<Integer> s2 = new Stack<>();
       for(int i = n - 1 ; i >= 0 ; i--){
        if(s1.isEmpty()){
            nsr[i] = n;
        }
        else if(!s1.isEmpty() && heights[s1.peek()] < heights[i]){
            nsr[i] = s1.peek();
        }
        else if(!s1.isEmpty() && heights[s1.peek()] >= heights[i]){
            while(!s1.isEmpty() && heights[s1.peek()] >= heights[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsr[i] = n;
            }
            else{
                nsr[i] = s1.peek();
            }
        }
        s1.push(i);
       } 
       for(int i = 0 ; i < n ; i++){
        if(s2.isEmpty()){
            nsl[i] = -1;
        }
        else if(!s2.isEmpty() && heights[s2.peek()] < heights[i]){
            nsl[i] = s2.peek();
        }
        else if(!s2.isEmpty() && heights[s2.peek()] >= heights[i]){
            while(!s2.isEmpty() && heights[s2.peek()] >= heights[i]){
                s2.pop();
            }
            if(s2.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s2.peek();
            }
        }
        s2.push(i);
       } 
       for(int i = 0 ; i < n ; i++){
        width[i] = nsr[i] - nsl[i] - 1;
       }
       int max = 0;
       for(int i = 0 ; i < n ; i++){
        max = Math.max(max , heights[i] * width[i]);
       }
       return max;
    }
}