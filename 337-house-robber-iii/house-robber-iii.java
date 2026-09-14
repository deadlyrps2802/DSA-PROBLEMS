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
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0],ans[1]);
    }

    public int[] helper(TreeNode root){
        if(root == null) return new int[2];

        int[] lefttree_choice = helper(root.left);
        int[] righttree_choice = helper(root.right);

        int[] options = new int[2];

        options[0] = root.val + lefttree_choice[1] + righttree_choice[1];

        options[1] = Math.max(lefttree_choice[0],lefttree_choice[1]) + Math.max(righttree_choice[0], righttree_choice[1]);


        return options;
    }
}