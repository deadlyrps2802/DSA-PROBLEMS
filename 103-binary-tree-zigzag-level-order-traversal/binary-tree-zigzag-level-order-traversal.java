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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currSize = 0;
        while(q.size()>0){
         int size = q.size();
            
            LinkedList<Integer> list = new LinkedList<>();

         for(int i = 0; i<size; i++){
            TreeNode front = q.remove();
               if(currSize%2==0){
                list.add(front.val);
               }
               else{
                list.addFirst(front.val);
               }

               if(front.left!=null) q.add(front.left);
               if(front.right!=null) q.add(front.right);
         }

         res.add(list);
         currSize++;

        }
        return res;
    }
}