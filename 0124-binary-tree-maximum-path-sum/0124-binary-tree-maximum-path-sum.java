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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return max;
    }
    public int maxsum(TreeNode node){
        if(node == null) return 0;
        
        int left = Math.max(0, maxsum(node.left));
        int right = Math.max(0, maxsum(node.right));
        // update global max (this is the answer candidate)
        max = Math.max(max, left + right + node.val);
        // return only one side
        return node.val + Math.max(left , right);
    }
}