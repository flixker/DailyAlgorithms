package me.fycus.nowcoder_leetcode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int n){
        if(head == null)
            return null;
        ListNode l = head;
        for(int i = 0; i < n; i++){
            if(l.next == null){
                l = head;
            }else
                l = l.next;
        }
        ListNode tail = head;

        while(l.next != null){
            tail = tail.next;
            l = l.next;
        }

        l.next = head;
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
