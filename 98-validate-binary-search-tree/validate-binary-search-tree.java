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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        Inorder(root,arr);

        for(int i = 1; i<arr.size(); i++){
            if(arr.get(i) <= arr.get(i-1)){
               return false;
            }
        }

        return true;
    }

    private void Inorder(TreeNode node,  ArrayList<Integer> arr ){
        if(node == null) return;

        Inorder(node.left,arr);
        arr.add(node.val);
        Inorder(node.right,arr);

        
    }
}