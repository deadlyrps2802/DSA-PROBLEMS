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
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> arr  = new ArrayList<>();
        preorder(root,arr);
        for(int i = 0 ; i<arr.size()-1 ; i++){
            TreeNode temp1 = arr.get(i);
            TreeNode temp2 = arr.get(i+1);

            temp1.right = temp2;
            temp1.left = null;
            temp2.left = null; 
        }

        TreeNode last = arr.get(arr.size()-1);
        last.right = null;
        last.left = null;
    }

    public void preorder(TreeNode root, ArrayList<TreeNode> arr){
        if(root == null) return;
        arr.add(root);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }
}