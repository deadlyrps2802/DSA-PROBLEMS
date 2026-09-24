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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Double> list = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int curr_size = q.size();
             double avg = 0;
             double sum = 0;
             
           for(int i = 0; i<curr_size; i++){
              TreeNode node = q.poll();
                  sum = sum + (double)node.val;
             if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            }
             avg = (double)(sum / curr_size);
              list.add(avg);

         }

         return list;
    }
}