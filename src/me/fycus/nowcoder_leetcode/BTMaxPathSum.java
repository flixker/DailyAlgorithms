package me.fycus.nowcoder_leetcode;

public class BTMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        sum(root);
        return max;
    }
    private int sum(TreeNode node){
        if(node == null)
            return 0;
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        int passedNum = Math.max(Math.max(leftSum + node.val, rightSum + node.val), node.val);
        int thisMax = Math.max(passedNum,leftSum + rightSum + node.val);
        max = Math.max(thisMax, max);
        return passedNum;
    }
}
