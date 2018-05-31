package me.fycus;

import java.util.ArrayList;
import java.util.Stack;

public class BTPreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> result = new ArrayList();
        TreeNode p = root;
        TreeNode peek;
        TreeNode r = null;
        while(p != null || !stack.isEmpty()){
            if(p != null && p != r){
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            else{
                peek = stack.pop();
                if(peek.right != null)
                    p = peek.right;
                else{
                    if(stack.isEmpty())
                        break;
                    p = stack.peek();
                    r = p;
                }
            }
        }
        return result;
    }
}
