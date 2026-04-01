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
class Pair{
    TreeNode node;
    int level;

    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            TreeNode node = cur.node;
            int hd = cur.level;

            map.put(hd, node.val);
            if(node.left != null){
                q.offer(new Pair(node.left, hd + 1));
            }
            if(node.right != null){
                q.offer(new Pair(node.right, hd + 1));
            }
        } 
        for(Integer val : map.values()){
            list.add(val);
        }
        return list;
    }
}