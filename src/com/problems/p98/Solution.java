package com.problems.p98;
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
    public boolean isValid(TreeNode root,long min,long max) {
        if(root==null)return true;
        if(root.val>=max || root.val<=min)return false;
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);

    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root) {
        if(root==null){
            return true;
        }

        if(root.right!=null && root.val >= dfsLeft(root.right).val){
            return false;
        }
        if(root.left!=null && root.val <= dfsRight(root.left).val){
            return false;
        }


        return isValidBST(root.left) && isValidBST(root.right);

    }


    public TreeNode dfsRight(TreeNode root){
        if(root.right!=null){
            return dfsRight(root.right);
        }
        return root;
    }
    public TreeNode dfsLeft(TreeNode root){
        if(root.left!=null){
            return dfsLeft(root.left);
        }
        return root;
    }
}
