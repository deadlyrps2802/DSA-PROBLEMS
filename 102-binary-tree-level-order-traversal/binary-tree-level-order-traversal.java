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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();
        if(root == null) return  list;

        

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
           
        int currSize = q.size();

        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i<currSize; i++){
           TreeNode front = q.remove();

           res.add(front.val);

           if(front.left!=null) q.add(front.left);
           if(front.right!=null) q.add(front.right);


        }
        list.add(res);
        }
        return list;
    }
}