package com.problems.p530;
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
    public int getMinimumDifference(TreeNode root) {

        int minDiff = Integer.MAX_VALUE;
        if(root==null)return minDiff;
        if(root.right!=null){
            int minOfRight = getMinOfRight(root.right);
            int tmp= minOfRight-root.val;
            if(tmp<minDiff)minDiff = tmp;
        }

        if(root.left!=null){
            int maxOfLeft = getMaxOfLeft(root.left);
            int tmp= root.val-maxOfLeft;
            if(tmp<minDiff)minDiff = tmp;
        }
        return Math.min(Math.min(minDiff,getMinimumDifference(root.left)) ,getMinimumDifference(root.right));


    }

    public int getMinOfRight(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }

        return root.val;

    }

    public int getMaxOfLeft(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }

        return root.val;
    }


}
