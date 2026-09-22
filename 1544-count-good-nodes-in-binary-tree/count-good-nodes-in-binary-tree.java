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
    public int goodNodes(TreeNode root) {
        
        if(root == null) return 0;

        return dfs(root,root.val);
    
    }

    private int dfs(TreeNode node , int curr_max){
        if(node == null) return 0;

        int count = 0;

        if(node.val >= curr_max){
            count++;
            curr_max = node.val;
        }

        count += dfs(node.left,curr_max);
        count += dfs(node.right, curr_max);

    return count;

    }

}