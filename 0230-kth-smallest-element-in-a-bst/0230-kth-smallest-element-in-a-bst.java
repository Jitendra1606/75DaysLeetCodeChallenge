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

class Solution{
    int ans = Integer.MAX_VALUE;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k){
        inorder(root, k);
        return ans;
    }
    public void inorder(TreeNode node, int k){
        if(node == null) return;
        inorder(node.left, k);
        cnt++;
        if(cnt == k) ans = node.val;
        inorder(node.right, k);
    }
}

// with inorder traversal the nodes got arranged in ascending order here we are using only recursive stack space but we are consuming memory by external storage sc O(n)
// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public int kthSmallest(TreeNode root, int k) {
//         inorder(root);
//         return list.get(k - 1);
//     }
//     public void inorder(TreeNode node){
//         if(node == null) return;
//         inorder(node.left);
//         list.add(node.val);
//         inorder(node.right);
//     }
// }