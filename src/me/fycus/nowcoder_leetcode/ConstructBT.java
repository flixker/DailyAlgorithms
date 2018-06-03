package me.fycus.nowcoder_leetcode;

import java.util.Arrays;

public class ConstructBT {
    public static void main(String[] args){
        int[] test = new int[10];
        for(int i = 0; i < 10; i++)
            test[i] = i;
        int[] copy = Arrays.copyOfRange(test,0,0);
        for(int i : copy)
            System.out.print(i + " ");

        int[] inorder = new int[]{-1};
        int[] postorder = new int[]{-1};
        ConstructBT cbt = new ConstructBT();
        TreeNode root = cbt.buildTree(inorder,postorder);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        TreeNode root = buildTree(new TreeNode(0), inorder, postorder);
        return root;
    }
    private TreeNode buildTree(TreeNode root, int[] in, int[] post){
        if(in.length == 0)
            return null;
        root.val = post[post.length - 1];
        int inIndex = 0;
        while(in[inIndex] != root.val)
            inIndex++;
        int[] leftIn = Arrays.copyOfRange(in, 0, inIndex);
        int[] rightIn = Arrays.copyOfRange(in, Math.min(inIndex + 1, in.length), in.length);
        int[] leftPost = Arrays.copyOfRange(post,0,inIndex);
        int[] rightPost = Arrays.copyOfRange(post, inIndex,post.length - 1);
        root.left = buildTree(new TreeNode(0), leftIn, leftPost);
        root.right = buildTree(new TreeNode(0), rightIn, rightPost);
        return root;
    }
}
