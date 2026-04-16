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
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        if(p.val != q.val) return false;
        if(!isSameTree(p.left, q.left)) return false;
        if(!isSameTree(p.right, q.right)) return false;
        return true;
    }
}


// class Solution{
//     public boolean isSameTree(TreeNode p, TreeNode q){
//         //when both null
//         if(p == null && q == null) return true;
//         //when either of one is not null
//         if(p == null || q == null) return false;
//         //checking values, that must be same
//         if(p.val != q .val) return false;
//         //moving forward
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }
