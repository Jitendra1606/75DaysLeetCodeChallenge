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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        paths(root, sb);
        return list;
    }
    public void paths(TreeNode node, StringBuilder sb){
        if(node == null) return;
        int len = sb.length();

        if(sb.length() > 0) sb.append("->");
        sb.append(node.val);

        if(node.left == null && node.right == null){
            list.add(sb.toString());
        }else{
            paths(node.left, sb);
            paths(node.right, sb);
        }
        sb.setLength(len);
    }
}