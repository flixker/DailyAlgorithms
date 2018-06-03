package me.fycus.nowcoder_leetcode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        ListNode l = head;
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        hh.next = head;
        ListNode last = hh;
        while(l != null && l.next != null){
            ListNode tem = l.next;
            l.next = tem.next;
            tem.next = last.next;
            last.next = tem;
            last = l;
            l = l.next;
        }
        return hh.next;
    }
}
