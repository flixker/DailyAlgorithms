package me.fycus;

import java.util.ArrayList;
import java.util.Stack;

public class BTPostorderTravesal {
    public ArrayList<Integer> postorderTraveral(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        TreeNode n = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack();
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != last) {
                    n = peek.right;
                } else {
                    peek = stack.pop();
                    last = peek;
                    result.add(peek.val);
                }
            }
        }
        return result;
    }
}
