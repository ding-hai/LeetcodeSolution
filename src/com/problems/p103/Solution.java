package com.problems.p103;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        dfs(root,result,0);
        return result;
    }

    public void dfs(TreeNode root,List<List<Integer>> list,int depth){
        if(root==null) return;
        if(list.size()<depth+1){
           List<Integer> item = new ArrayList();
            list.add(item);
        }
        if(depth%2==0){
            list.get(depth).add(root.val);
        }else{
            list.get(depth).add(0,root.val);
        }


        dfs(root.left,list,depth+1);
        dfs(root.right,list,depth+1);
    }
}
