package com.problems.p102;
import java.util.LinkedList;
import java.util.Queue;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  result = new ArrayList();
        dfs(root,result,0);
        return result;
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

    public List<List<Integer>> levelOrder2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        List<Integer> resultItem = new ArrayList();
        if(null == root){
            return result;
        }
        queue.offer(root);
        int lengthOfThisLayer = 1;
        while(queue.size()>0){
             if(lengthOfThisLayer == 0){
                 lengthOfThisLayer = queue.size();
                 result.add(resultItem);
                 resultItem = new ArrayList();
                 //System.out.println("next layer");
             }

            TreeNode temp = queue.poll();
            //System.out.println(temp.val);
            resultItem.add(temp.val);
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right !=null)
                queue.offer(temp.right);

            lengthOfThisLayer--;
        }
        result.add(resultItem);
        return result;
    }
}
