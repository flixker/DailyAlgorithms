package me.fycus.nowcoder_leetcode;

import java.util.LinkedList;

public class MinDepthOfBT {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(get2(node1));
    }
    public int run(TreeNode root){
        if(root == null)
            return 0;
        return get(root, 1);
    }

    private int get(TreeNode node, int depth){
        if(node.left != null || node.right != null) {
            if (node.right == null)
                return get(node.left, depth + 1);
            else if(node.left == null)
                return get(node.right, depth + 1);
            else
                return Math.min(get(node.left, depth + 1),get(node.right, depth + 1));
        }
        return depth;
    }

    //无法找到合适的方法避开空节点
    private static int get2(TreeNode root){
        if(root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int count = 0;
        int layer = 1;
        TreeNode removed = null;
        while(true){
            removed = queue.remove();
            count++;
            if(removed == null) {
                continue;
            }
            if(removed.left == null && removed.right == null)
                break;
            queue.add(removed.left);
            queue.add(removed.right);
        }
        while(count > Math.pow(2,layer) - 1){
            layer++;
        }
        return layer;
    }
}
