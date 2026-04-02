/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //base case
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //result
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{//both left and rigth are not null, we found our result
            return root;
        }
    }
}


//one way to solve this is by calculating path from root node to both given nodes and after comparing the values till both values matched and the answer is our last matched node and stop when not matched but it's space complexity will be more bcz of storing both paths
// class Solution {
//     List<TreeNode> list1 = new ArrayList<>();
//     List<TreeNode> list2 = new ArrayList<>();
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         solve(root, p, list1);
//         solve(root, q, list2);
//         int min = Math.min(list1.size(), list2.size());
//         TreeNode ans = null;
//         for(int i = 0 ; i < min ; i++){
//             if(list1.get(i) == list2.get(i)){
//                 ans = list1.get(i);
//             }else{
//                 break;
//             }
//         }
//         return ans;
//     }
//     public boolean solve(TreeNode node, TreeNode p, List<TreeNode> list){
//         if(node == null) return false;
//         list.add(node);
//         if(node == p) return true;
//         if(solve(node.left, p, list) || solve(node.right, p, list)){
//             return true;
//         }
//         list.remove(list.size() - 1);
//         return false;
//     }
// }