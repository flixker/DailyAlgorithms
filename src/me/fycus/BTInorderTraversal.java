package me.fycus;

import java.util.ArrayList;

public class BTInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root){

        ArrayList<Integer> list = new ArrayList();

        TreeNode p = root;
        TreeNode temp;
        while(p != null){
            if(p.left == null){
                list.add(p.val);
                p = p.right;
            }
            else{
                TreeNode tmp = p.left;
                while(tmp.right != null && tmp.right != p){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = p;
                    p = p.left;
                }
                else{
                    tmp.right = null;
                    list.add(p.val);
                    p = p.right;
                }
            }
        }
        return list;
    }
}
