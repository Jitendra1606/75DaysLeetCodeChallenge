class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(0);
            }

            else{
                int inner = st.pop();

                int score = (inner == 0) ? 1 : 2 * inner;

                st.push(st.pop() + score);
            }
        }
        return st.pop();
    }
}


// Let's dry run:
// s = "(()())"

// Expected answer:
// 4

// Because:
// (()())
//    ↓
// 2 × (()())

// Inside we have:
// ()()
//  ↓
// 1 + 1 = 2

// Therefore:
// 2 × 2 = 4

// Step 1: Initial state
// Stack<Integer> st = new Stack<>();
// st.push(0);

// Stack:
// ┌───┐
// │ 0 │  ← bottom
// └───┘

// Why did we put 0?
// This represents the score of the outermost level.
// Step 2: First character (
// String:
// ( ( ) ( ) )
// ↑

// We execute:
// if (ch == '(') {
//     st.push(0);
// }

// So:
// st = [0, 0]

// Meaning:
// 0 → outer level
// 0 → score inside first '('

// Step 3: Second character (
// String:
// ( ( ) ( ) )
//   ↑

// Again:
// st.push(0);

// Stack:
// st = [0, 0, 0]

// Think of it as:
// outer level
//     ↓
// [0,     // outside
//  0,     // first (
//  0]     // second (

// Step 4: Third character )
// String:
// ( ( ) ( ) )
//     ↑

// Now:
// int inner = st.pop();

// The top is 0.
// So:
// inner = 0

// Stack becomes:
// [0, 0]

// Now:
// int score = (inner == 0) ? 1 : 2 * inner;

// Since:
// inner == 0

// we get:
// score = 1

// Why?
// Because we have:
// ()

// and:
// score("()") = 1

// Now:
// st.push(st.pop() + score);

// First:
// st.pop()

// removes the previous 0.
// So:
// st = [0]

// Then:
// 0 + 1 = 1

// Push it:
// st = [0, 1]

// So our stack now represents:
// outer
//   ↓
// [0, 1]
//     ↑
//   score of ()

// Step 5: Fourth character (
// String:
// ( ( ) ( ) )
//       ↑

// We encounter (:
// st.push(0);

// Stack:
// [0, 1, 0]

// Meaning:
// 0 → outer score
// 1 → score of first ()
// 0 → currently calculating second (

// Step 6: Fifth character )
// String:
// ( ( ) ( ) )
//         ↑

// Again:
// int inner = st.pop();

// Top is:
// 0

// Therefore:
// inner = 0

// Stack:
// [0, 1]

// Since:
// inner == 0

// we have:
// score = 1

// because this is:
// ()

// Now:
// st.push(st.pop() + score);

// Pop:
// st.pop() = 1

// Then:
// 1 + 1 = 2

// Push:
// st = [0, 2]

// Now we have calculated:
// ()()

// Its score is:
// 1 + 1 = 2

// So:
// [0, 2]

// means:
// outer score = 0
// inner score = 2

// Step 7: Sixth character )
// String:
// ( ( ) ( ) )
//           ↑

// Now:
// int inner = st.pop();

// Top is:
// 2

// Therefore:
// inner = 2

// Stack:
// [0]

// Now:
// int score = (inner == 0) ? 1 : 2 * inner;

// Since:
// inner != 0

// we calculate:
// score = 2 * 2
//       = 4

// Why multiply by 2?
// Because the structure is:
// (
//     ()()
// )

// which follows:
// (A) = 2 × score(A)

// and:
// score(()()) = 2 × score(()())

// Inside:
// ()()

// has score:
// 1 + 1 = 2

// Therefore:
// 2 × 2 = 4

// Now:
// st.push(st.pop() + score);

// Current stack:
// [0]

// Pop:
// 0

// Add:
// 0 + 4 = 4

// Push:
// st = [4]

// Step 8: Loop finishes
// All characters have been processed.
// Stack:
// [4]

// Finally:
// return st.pop();

// returns:
// 4

// Final answer
// 4

// The most important part to understand
// The stack is not storing parentheses.
// It is storing the score of each nesting level.
// For:
// (()())

// the stack progression is:
// Start       [0]

// (           [0, 0]

// (           [0, 0, 0]

// )           [0, 1]

// (           [0, 1, 0]

// )           [0, 2]

// )           [4]

// The crucial rule is:
// inner == 0

// means:
// ()

// so:
// score = 1

// While:
// inner != 0

// means:
// (A)

// so:
// score = 2 * inner

// That's the entire logic behind the solution.