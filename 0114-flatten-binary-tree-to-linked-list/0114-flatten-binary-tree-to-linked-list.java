/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//optimal approach --> tc = O(n), sc = O(1)
//learn this one with dry run(important to learn)
class Solution{
    public void flatten(TreeNode root){
        // Initialize a pointer
        // 'curr' to the root of the tree
        TreeNode cur = root;
        // Iterate until 'curr'
        // becomes NULL
        while(cur != null){
            // Check if the current
            // node has a left child
            if(cur.left != null){
                // If yes, find the rightmost
                // node in the left subtree
                TreeNode pre = cur.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = cur.right;
                // Move the entire left subtree to the
                // right child of the current node
                cur.right = cur.left;
                // Set the left child of
                // the current node to NULL
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}


// same complexity tc = O(n), sc = O(log2n)
// class Solution{
//     TreeNode prev = null;
//     public void flatten(TreeNode root){
//         if(root == null) return;
//         Deque<TreeNode> st = new ArrayDeque<>();
//         //push root to start traversal
//         st.push(root);
//         //process while sack has nodes
//         while(!st.isEmpty()){
//             //take top node
//             TreeNode cur = st.pop();
//             //push right child first(so left is processed first)
//             if(cur.right != null) st.push(cur.right);
//             //push left child next
//             if(cur.left != null) st.push(cur.left);
//             //if stack is not empty, then link the cuurent's right to next node
//             if(!st.isEmpty()) cur.right = st.peek();
//             cur.left = null;
//         }
//     }
// }


//right left root approach
//tc = O(n) , sc = O(log2n)
// class Solution {
//     TreeNode prev = null;
//     public void flatten(TreeNode root) {
//         if(root == null) return;
//         //flatten rigth subtree first
//         flatten(root.right);
//         //flatten left subtree next
//         flatten(root.left);
//         //connect current node's rigth to previously proccessed node
//         root.right = prev;
//         //nullify left pointer
//         root.left = null;
//         //update previous to current
//         prev = root;
//     }
// }