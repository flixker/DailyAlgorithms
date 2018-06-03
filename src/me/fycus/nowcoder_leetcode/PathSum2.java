package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

public class PathSum2 {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        System.out.println(pathSum(node1,1));
    }
    private static ArrayList<ArrayList<Integer>> result;
    private static ArrayList<Integer> list;
    private static int object;
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        object = sum;
        result = new ArrayList();
        list = new ArrayList();
        search(root,0);
        return result;
    }
    private static void search(TreeNode node, int presum){
        if(node == null)
            return;
        list.add(node.val);
        int now = presum + node.val;
        if(node.left == null && node.right == null){
            if(now == object){
                result.add(new ArrayList<Integer>(list));
            }
        }
            search(node.left, now);
            search(node.right, now);
        list.remove(list.size() - 1);
    }

}
