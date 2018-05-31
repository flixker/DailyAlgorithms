package me.fycus;

import java.util.ArrayList;

public class UniqueBST2 {
    public static void main(String[] args){
        UniqueBST2 test = new UniqueBST2();
        ArrayList<TreeNode> result = test.generateTrees(3);
        System.out.print(result.size());
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<>();
        result = generateTrees(1, n);
        return result;
    }
    private ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<>();
        int extend = end - start + 1;
        if(extend == 0) {
            result.add(null);
            return result;
        }
        if(extend == 1){
            result.add(new TreeNode(start));
            return result;
        }
        for(int i = start; i <= end; i++){
            ArrayList<TreeNode> left = generateTrees(start, i - 1);
            ArrayList<TreeNode> right = generateTrees(i + 1, end);
            for(TreeNode m : left){
                for(TreeNode n : right){
                    TreeNode root = new TreeNode(i);
                    root.left = m;
                    root.right = n;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
