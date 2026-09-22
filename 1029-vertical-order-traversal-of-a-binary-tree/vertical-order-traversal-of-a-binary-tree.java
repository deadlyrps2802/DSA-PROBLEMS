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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(root == null) return ans;
     

        Queue<Map.Entry<TreeNode,Integer>> q = new ArrayDeque<>();
        Map<Integer , ArrayList<Integer>> map = new HashMap<>();
    
       q.offer(new java.util.AbstractMap.SimpleEntry<>(root,0));
       int min = 0;
       int max = 0;

       while(!q.isEmpty()){
        int size = q.size();
        Map<Integer,List<Integer>> curr_map = new HashMap<>();
       
       for(int i = 0; i< size; i++){
        Map.Entry<TreeNode,Integer> it = q.poll();
        TreeNode curr_node = it.getKey();
        int col = it.getValue();

        min = Math.min(min , col);
        max = Math.max(max,col);

        curr_map.putIfAbsent(col, new ArrayList<>());
        curr_map.get(col).add(curr_node.val);

        if(curr_node.left!=null){
            q.offer(new AbstractMap.SimpleEntry<>(curr_node.left, col -1));
        }
         if(curr_node.right!=null){
            q.offer(new AbstractMap.SimpleEntry<>(curr_node.right, col +1));
        }

       }
      for(Map.Entry<Integer,List<Integer>> x : curr_map.entrySet()){
        int col = x.getKey();
        List<Integer> arr = x.getValue();
        Collections.sort(arr);

        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).addAll(arr);
      }
       
       
       }

    for(int i = min; i<= max ; i++){
        ans.add(map.get(i));
    }
    
    
    return ans;
    }
}