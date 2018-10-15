package com.problems.p623;

import sun.reflect.generics.tree.Tree;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode newRoot = dfs(root, null, 1, d, v, true);
        return newRoot;
    }

    public void showTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("showTreeNode:" + root.val);

        showTreeNode(root.left);
        showTreeNode(root.right);
    }

    public TreeNode dfs(TreeNode node, TreeNode parent, int level, int d, int v, boolean leftOrRight) {


        if (level == d) {
            if (d == 1) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = node;
                return newRoot;
            } else {
                if (leftOrRight) {

                    TreeNode tmpLeft = parent.left;
                    TreeNode treeNode = new TreeNode(v);
                    treeNode.left = tmpLeft;
                    parent.left = treeNode;
                } else {
                    TreeNode tmpRight = parent.right;
                    TreeNode treeNode = new TreeNode(v);
                    treeNode.right = tmpRight;
                    parent.right = treeNode;
                }
            }
        }

        if (node == null) {
            return null;
        }

        System.out.println(node.val);
        TreeNode left = node.left;
        TreeNode right = node.right;
        level++;

        dfs(left, node, level, d, v, true);

        dfs(right, node, level, d, v, false);
        return node;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        Solution solution = new Solution();
        TreeNode newRoot = solution.dfs(root, null, 1, 3, 6, true);
        solution.showTreeNode(newRoot);
    }
}