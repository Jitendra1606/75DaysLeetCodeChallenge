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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0 ; i < level ; i++){
                TreeNode node = q.poll();
                //insert children in the same order
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                //only change when storing
                if(flag == 0){
                    ans.add(node.val);
                }else{
                    ans.add(0, node.val);
                }
            }
            list.add(ans);
            flag = 1 - flag; // flip after each level
        }
        return list;
    }
}

//ans.add(0, node.val) at line 35
//In Java List, this method: add(index, element)
//Insert element at that index, ans.add(0, node.val);
//Insert the value at the beginning of the list
//List<Integer> ans = new ArrayList<>();
//ans.add(1);        // [1]
//ans.add(2);        // [1, 2]
//ans.add(0, 3);     // [3, 1, 2]
//See? 3 goes to the front
//Why we use it in zigzag
//Normal level (left → right):
//ans.add(node.val);
//builds: [2, 3]
//Reverse level (right → left):
//ans.add(0, node.val);
//Step-by-step:
//add 2 → [2]
//add 3 → [3, 2]
//Automatically reversed 
// We do:
// Traverse normally
// But insert at front to reverse effect


