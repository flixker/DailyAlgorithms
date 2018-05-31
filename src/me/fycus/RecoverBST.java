package me.fycus;

public class RecoverBST {

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;

        RecoverBST r = new RecoverBST();
        r.recoverTree(node1);
    }
    public void recoverTree(TreeNode root){
        //二叉搜索树的中序遍历结果是有序的
        TreeNode p = root;
        TreeNode firstErr = null;
        TreeNode secondErr = null;
        TreeNode pre = null;
        TreeNode tmp;
        TreeNode out;
        while(p != null){
            if(p.left == null){
                out = p;
                p = p.right;
            }
            else{
                tmp = p.left;
                while(tmp.right != null && tmp.right != p){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = p;
                    p = p.left;
                    out = null;
                }
                else{
                    out = p;
                    p = p.right;
                    tmp.right = null;
                }
            }
            if(out != null){
                if(pre != null && pre.val > out.val){
                    if(firstErr != null){
                        secondErr = out;
                    }else{
                        firstErr = pre;
                        secondErr = out;
                    }
                }
                pre = out;
            }
        }

        int t = firstErr.val;
        firstErr.val = secondErr.val;
        secondErr.val = t;
    }
}
