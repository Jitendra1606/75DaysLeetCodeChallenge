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
    int cnt;

    public int countDominantNodes(TreeNode root) {
        cnt = 0;
        solve(root);

        return cnt;
    }

    public int solve(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int left = solve(node.left);
        int right = solve(node.right);

        int max = Math.max(node.val, Math.max(left, right));

        if (node.val == max)
            cnt++;

        return max;
    }
}