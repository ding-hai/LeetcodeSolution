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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);

    }


    private boolean isSymmetric(TreeNode aTree,TreeNode bTree){
        List<TreeNode> layer = new ArrayList();
        if(aTree==null || bTree==null){return aTree==bTree;}

        if(aTree.val==bTree.val){
            layer.add(aTree.left);
            layer.add(aTree.right);
            layer.add(bTree.left);
            layer.add(bTree.right);
            return isSymmetric(aTree.left,bTree.right) && isSymmetric(aTree.right,bTree.left);
        }
        return false;
    }

}
