/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//simple while loop which does not take any space
class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}


//this is recursive approach which takes extra recursive stack  space
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return null;
//         int current = root.val;
//         if(current < p.val && current < q.val){
//             return lowestCommonAncestor(root.right, p, q);
//         }
//         else if(current > p.val && current > q.val){
//             return lowestCommonAncestor(root.left, p, q);
//         }
//         else{
//             return root;
//         }
//     }
// }