package me.fycus;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head){
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        if(head == slow)
            return root;
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
}
