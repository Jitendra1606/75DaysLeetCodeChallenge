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
//we just have to invert children of each node
//   6             6
//  / \   == >    / \
// 5   7         7   5
//the same proccess is repeating for each node
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root == null) return root;

//         TreeNode left = invertTree(root.left);
//         TreeNode right = invertTree(root.right);

//         root.left = right;
//         root.right = left;

//         return root;
//     }
// }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            //swap childs
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        return root;
    }
}

// Method 2: Iterative (BFS using Queue)
// 🧠 Intuition (very simple)

// Instead of going deep (recursion), we go level by level.

// Think:

// “Visit each node and just swap its children immediately.”

// So:

// Take a node
// Swap its left & right
// Put its children in queue
// Repeat
// 🌳 Visual Idea

// Original:

//      4
//    /   \
//   2     7

// Step-by-step:

// Take 4 → swap → (7, 2)
// Then process 7, 2
// Then their children...