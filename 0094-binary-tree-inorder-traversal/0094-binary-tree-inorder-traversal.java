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
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    public void inorder(TreeNode node){
        //left root right
        //if left.rootnode == null return o/w list.add left.rootnode
        if(node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
        // list.add(node.val);
    }
}