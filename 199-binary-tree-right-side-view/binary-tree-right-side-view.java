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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        viewlevel(root,0,arr);
        return arr;
    }

    public void viewlevel(TreeNode root , int level , ArrayList<Integer> arr){
        if(root == null) return;
        if(arr.size()<= level){
            arr.add(root.val);
        }
        else{
            arr.set(level,root.val);
        }
        viewlevel(root.left,level+1,arr);
        viewlevel(root.right,level+1,arr);
    }
}