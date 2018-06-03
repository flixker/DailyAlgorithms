package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(list);
        }
        ArrayList<ArrayList<Integer>> reverse = new ArrayList();
        int resultSize = result.size();
        for(int i = resultSize - 1; i >= 0; i--){
            reverse.add(result.get(i));
        }
        return reverse;
    }
}
