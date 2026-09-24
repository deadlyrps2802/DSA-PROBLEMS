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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.offer(root);

        while(!q.isEmpty()){
            int curr_size = q.size();
           List<Integer> list = new ArrayList<Integer>();         
              
            for(int i = 0; i<curr_size; i++){
                TreeNode node = q.poll();
                 
                 list.add(node.val);

               if(node.left!=null) q.offer(node.left);
               if(node.right!= null) q.offer(node.right);
                 
            }

            result.add(list);
        }
        Collections.reverse(result);
      
      return result;
    
    }
}