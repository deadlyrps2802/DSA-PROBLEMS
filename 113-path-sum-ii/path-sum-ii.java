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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      
        List<List<Integer>> ans = new ArrayList<>();

          if(root == null) return ans ;
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root, arr ,ans, targetSum);
        return ans;
    }

    public void dfs(TreeNode root , ArrayList<Integer> arr , List<List<Integer>> ans , int sum){
        if(root == null) return;
        arr.add(root.val);

        if(root.left == null && root.right==null && sum == root.val){
            ans.add(new ArrayList<>(arr));
        }
else{
        dfs(root.left, arr , ans , sum- root.val);
         dfs(root.right, arr , ans , sum- root.val);
}
         arr.remove(arr.size()-1);
    }
}