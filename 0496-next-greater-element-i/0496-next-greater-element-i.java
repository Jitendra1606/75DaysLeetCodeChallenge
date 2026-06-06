//instead of creating a new array to store next greater element of array we can directly store this data in hashmap as we have to use this data to answer the next greater element in nums2 corresponding to nums1

class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n = nums1.length;

        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1 ; i >= 0 ;i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            int next_gtr = st.isEmpty() ? -1 : st.peek();
            
            map.put(nums2[i], next_gtr);

            st.push(nums2[i]);
        }
        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
//t.c = O(n)
//s.c = O(n)