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
 //heigth of left tree + height of rigth tree
class Solution {
    int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return diam;
    }
    public int diameter(TreeNode node){
        if(node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);
        diam = Math.max(diam, left + right);
        return 1 + Math.max(left,right);
    }
}