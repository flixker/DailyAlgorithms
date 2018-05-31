package me.fycus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTLevelOrderTraversal {

    //better version
    public ArrayList<ArrayList<Integer>> betterVersion(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            //用size来控制层数
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
            //result.add(0,list);
            result.add(list);
        }
        return result;
    }



    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList();
        int nextLack = 0;
        int layer = 1;
        int count = 0;
        ArrayList<Integer> layerList = new ArrayList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            count++;
            if(count > Math.pow(2,layer) - 1){
                result.add(layerList);
                layerList = new ArrayList();
                count += nextLack;
                nextLack = nextLack * 2;
                layer++;
            }
            layerList.add(p.val);
            if(p.left != null)
                queue.add(p.left);
            else
                nextLack++;
            if(p.right != null)
                queue.add(p.right);
            else
                nextLack++;
        }
        result.add(layerList);
        return result;
    }
}
