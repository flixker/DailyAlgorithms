package me.fycus.nowcoder_leetcode;

public class PartitionList {
    public ListNode partition(ListNode head, int x){
        ListNode border = null;
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        hh.next = head;
        ListNode n = hh;
        while(n.next != null){
            if(n.next.val >= x) {
                border = n;
                break;
            }
            n = n.next;
        }

        if(border == null)
            return head;
        n = border.next;
        ListNode last = border;
        while(n != null){
            ListNode next;
            if(n.val < x){
                next = n.next;

                last.next = n.next;
                ListNode bn = border.next;
                border.next = n;
                n.next = bn;
                border = border.next;

                n = next;
            }else{
                last = n;
                n = n.next;
            }
        }
        return hh.next;
    }
}
