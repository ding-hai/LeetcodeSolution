package com.problems.p107;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> reverseResult = new ArrayList();
        dfs(root,result,0);
        for(int i=0;i<result.size();i++){
            List<Integer> temp = result.get(i);
            reverseResult.add(0,temp);
        }
        return reverseResult;
    }
    public void dfs(TreeNode root,List<List<Integer>> list,int depth){
        if(root==null) return;
        if(list.size()<depth+1){
           List<Integer> item = new ArrayList();
            list.add(item);
        }
        list.get(depth).add(root.val);

        dfs(root.left,list,depth+1);
        dfs(root.right,list,depth+1);
    }
}
