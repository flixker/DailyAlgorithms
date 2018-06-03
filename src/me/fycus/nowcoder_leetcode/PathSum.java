package me.fycus.nowcoder_leetcode;

public class PathSum {
    private int object = 0;
    private boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null)
            return false;
        object = sum;
        search(root,0);
        return flag;
    }
    private void search(TreeNode node, int presum){
        if(node == null)
            return;
        int now = presum + node.val;
        if(node.left == null && node.right == null){
            if(now == object)
                flag = true;
            return;
        }
        search(node.left, now);
        search(node.right, now);
    }
}
