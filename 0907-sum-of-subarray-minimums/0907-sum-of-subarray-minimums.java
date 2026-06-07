//in this ques the observation is the contribution of each number as min in the no. of subarrays and we are finding this occurence by finding the nsl & nsr of that number and between this range obviously that no. is the smallest so just multiplying it's contributuion with the array's value we can get our answer by finding and adding for all the numbers of arrays

class Solution {
    static int M = (int)(1e9 + 7);
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] nsl = new int[n]; //finding next smaller to left of no. & storing ind of that no.
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            nsl[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        int[] nsr = new int[n]; //finding next smaller to right of no. & storing ind of that no.
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            nsr[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        long tot = 0;
        for(int i = 0 ; i < n ; i++){
            long left = i - nsl[i];
            long right = nsr[i] - i;

            long sum = ((left * right) % M * arr[i]) % M;
            tot = (sum + tot) % M;
        }
        return (int)tot;
    }
}