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
    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < level ; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            result.add(list);
        }
        int size = result.size();
        int sum = 0;
        List<Integer> lastlist = result.get(result.size() - 1);
        for(int i = 0 ; i < lastlist.size() ; i++){
            sum = sum + result.get(result.size() - 1).get(i);
        }
        return sum;
    }
}