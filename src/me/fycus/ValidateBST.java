package me.fycus;

public class ValidateBST {
    public boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        if(root.left != null && maxNum(root.left) >= root.val)
            return false;
        if(root.right != null && minNum(root.right) <= root.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    private int minNum(TreeNode root){
        if(root.left == null)
            return root.val;
        return minNum(root.left);
    }
    private int maxNum(TreeNode root){
        if(root.right == null)
            return root.val;
        return maxNum(root.right);
    }
}
