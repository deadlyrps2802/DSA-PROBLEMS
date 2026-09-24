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
 import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int depth1 = finddepth(root,x);
        int depth2 = finddepth(root,y);

        
        
        if(depth1 == depth2 && !isSibling(root, x, y)) return true;


        return false;
    }


    private int finddepth(TreeNode root, int key){
        Queue<Map.Entry<TreeNode,Integer>> q = new ArrayDeque<>();

        q.offer(new AbstractMap.SimpleEntry<>(root,0));

        while(!q.isEmpty()){
            int curr_size = q.size();

            for(int i = 0; i<curr_size; i++){
                Map.Entry<TreeNode,Integer> it = q.poll();

                TreeNode node = it.getKey();
                int depth = it.getValue();

                if(node.val == key) return depth;

                if(node.left!=null)  q.offer(new AbstractMap.SimpleEntry<>(node.left,depth+1));

                  if(node.right!=null)  q.offer(new AbstractMap.SimpleEntry<>(node.right,depth+1));
            }
        }

        return 0;
    }

    private boolean isSibling(TreeNode node ,int x , int y){
        if(node == null) return false;
       boolean issib = false;
       if(node.left!=null && node.right!= null){
    

    issib = (node.left.val == x && node.right.val == y) ||  (node.left.val == y && node.right.val == x) ;
        
       }
       return issib || isSibling(node.left, x, y) || isSibling(node.right,x,y);
     }
}