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
 //with bfs(queue + level count)
class Solution{
    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();//no. of nodes at current level

            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                   q.offer(node.left);
                }
                if(node.right != null){
                   q.offer(node.right);
                }
            }
            
            level++;
        }
        return level;
    }
}

//dfs(recursion + max)
// class Solution {
//     public int maxDepth(TreeNode root) {
//         return depth(root);
//     }
//     public int depth(TreeNode node){
//         if(node == null) return 0;
//         int left = depth(node.left) + 1;
//         int right = depth(node.right) + 1;
//         return Math.max(left, right);
//     }
// }