package me.fycus;

import java.util.LinkedList;

public class MaxDepthOfBT {

    public static void main(String[] args){
        MaxDepthOfBT test = new MaxDepthOfBT();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        System.out.println(test.maxDepth(node1));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode p = queue.poll();
                if(p.left != null)
                    queue.add(p.left);
                if(p.right != null)
                    queue.add(p.right);
            }
            count++;
        }
        return count;
    }
}
