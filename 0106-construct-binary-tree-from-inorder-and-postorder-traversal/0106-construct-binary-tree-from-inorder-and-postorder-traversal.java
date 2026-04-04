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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    public TreeNode build(int[] in, int instart, int inend, int[] post, int poststart, int postend, Map<Integer, Integer> map){
        if(poststart > postend || instart > inend) return null;
        TreeNode root = new TreeNode(post[postend]);
        int inroot = map.get(post[postend]);
        int numsleft = inroot - instart;

        root.left = build(in, instart, inroot - 1, post, poststart, poststart + numsleft - 1, map);
        root.right = build(in, inroot + 1, inend, post, poststart + numsleft, postend - 1, map);
        return root;
    }
}