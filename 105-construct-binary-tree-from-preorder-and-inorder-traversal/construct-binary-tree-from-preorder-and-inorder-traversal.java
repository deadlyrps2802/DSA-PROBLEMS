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
     private int preorderIndx = 0;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
       
       for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
       }

       return build(preorder, 0 , inorder.length -1);
    
    }

    private TreeNode build(int[] preorder , int start , int end){
        if(start > end){
            return null;
        }
      
      int rootVal = preorder[preorderIndx++];
      TreeNode root = new TreeNode(rootVal);

      int rootIndx = map.get(rootVal);

      root.left = build(preorder , start , rootIndx -1);

      root.right = build(preorder , rootIndx + 1 , end);


         return root;
    }
}