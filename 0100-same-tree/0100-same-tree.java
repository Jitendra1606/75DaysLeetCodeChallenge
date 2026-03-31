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
        if(p.val != q .val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// class Solution {
//     List<Integer> list1 = new ArrayList<>();
//     List<Integer> list2 = new ArrayList<>();
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         inorder1(p);
//         inorder2(q);
//         if(list1.size() != list2.size()) return false;
//         for(int i = 0 ; i < list1.size() ; i++){
//             if(list1.get(i) != list2.get(i)) return false;
//         }
//         return true;
//     }
//     public void inorder1(TreeNode node){
//         if(node == null) return;
//         inorder1(node.left);
//         list1.add(node.val);
//         inorder1(node.right);
//     }
//     public void inorder2(TreeNode node){
//         if(node == null) return;
//         inorder2(node.left);
//         list2.add(node.val);
//         inorder2(node.right);
//     }
// }