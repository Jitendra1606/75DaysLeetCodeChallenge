class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int max = 0;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();

                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
}


// Let's do a complete example

// Consider:

// s = ")()())"
//      012345

// Expected answer:

// 4

// because:

// ()()

// has length 4.

// Start
// stack = [-1]
// max = 0
// i = 0
// s[0] = ')'

// We pop:

// stack = []

// Stack is empty.

// That means this ) cannot belong to any valid substring.

// So we make it the new boundary:

// st.push(i);

// Therefore:

// stack = [0]

// Think:

// ) | ()()
// ^
// boundary
// i = 1
// s[1] = '('

// Push its index:

// stack = [0, 1]
// i = 2
// s[2] = ')'

// Pop:

// stack = [0]

// Now stack isn't empty.

// Calculate:

// i - st.peek()
// = 2 - 0
// = 2

// So:

// max = 2

// We found:

// ()
// i = 3
// s[3] = '('

// Push:

// stack = [0, 3]
// i = 4
// s[4] = ')'

// Pop:

// stack = [0]

// Calculate:

// 4 - 0 = 4

// So:

// max = 4

// We found:

// ()()
// i = 5
// s[5] = ')'

// Pop:

// stack = []

// It's empty.

// So this ) cannot be part of a valid substring.

// Make it the new boundary:

// stack = [5]

// Done.

// Answer:

// 4
// So what are we actually doing?

// You can think of the algorithm like this:

// (
// "Maybe this can be matched later."

// → store its index
// )
// "Can I match a previous '('?"

// → remove one '(' from stack

// If after matching:

// stack is NOT empty

// then:

// i - stack.peek()

// is the length of the current valid substring.

// If:

// stack IS empty

// then this ) is an invalid boundary, so:

// stack.push(i)

// and we start looking for the next valid substring after this index.

// The one sentence you should remember

// The stack stores indices of unmatched opening brackets and the latest invalid boundary; whenever a ) successfully matches, the distance from its index to the top of the stack gives the length of the current valid parentheses substring.

// And that's why we use indices instead of characters.