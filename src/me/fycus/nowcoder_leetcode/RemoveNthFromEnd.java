package me.fycus.nowcoder_leetcode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        for(int i = 0; i < n; i++){
            if(l != null)
                l = l.next;
            else
                return head;
        }

        ListNode d = dummy;
        while(l.next != null){
            l = l.next;
            d = d.next;
        }
        d.next = d.next.next;
        return dummy.next;
    }
}
