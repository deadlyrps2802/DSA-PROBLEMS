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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root,k,set);
    }

    private boolean dfs(TreeNode node, int target , Set<Integer> set ){
        if(node == null) return false;

        if(set.contains(target-node.val)){
            return true;
        }

        set.add(node.val);

        return dfs(node.left,target,set)||dfs(node.right,target,set);
    }
}