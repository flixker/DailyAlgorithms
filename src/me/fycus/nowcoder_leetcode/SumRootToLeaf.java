package me.fycus.nowcoder_leetcode;

public class SumRootToLeaf {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(sumNumbers(node1));
    }
    private static int sum = 0;
    public static int sumNumbers(TreeNode root){
        if(root == null)
            return 0;
        dfs(root, 0);
        return sum;
    }
    private static void dfs(TreeNode node, int preNum){
        int num = preNum * 10 + node.val;
        if(node.left != null || node.right != null) {
            if (node.left != null)
                dfs(node.left, num);
            if (node.right != null)
                dfs(node.right, num);
        }
        else{
            System.out.println(num);
            sum += num;
        }
    }
}
