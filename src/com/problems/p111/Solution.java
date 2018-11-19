package com.problems.p111;
import java.util.Queue;
import java.util.LinkedList;

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
    private int minDepth = Integer.MAX_VALUE;;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;


        dfs(root,1);
        return minDepth;
    }

    public void dfs(TreeNode root,int depth){
        if(root==null)return ;

        if(root.left==null && root.right==null){
            minDepth = minDepth>depth?depth:minDepth;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }



}
