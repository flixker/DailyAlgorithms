package me.fycus.nowcoder_leetcode;

public class BalancedBT {
    boolean flag = true;
    public boolean isBalanced(TreeNode root){
        layer(root);
        return flag;
    }
    private int layer(TreeNode node){
        if(node == null || flag == false)
            return 0;
        int left = layer(node.left);
        int right = layer(node.right);
        if(Math.abs(left - right) > 1){
            flag = false;
            return 0;
        }
        return Math.max(left,right) + 1;
    }
}
