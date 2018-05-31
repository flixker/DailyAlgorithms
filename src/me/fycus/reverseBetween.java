package me.fycus;

public class reverseBetween {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode n = head;
        for(int i = 2; i < 6; i++){
            n.next = new ListNode(i);
            n = n.next;
        }
        n = head;
        while(n != null){
            System.out.print(" " + n.val);
            n = n.next;
        }

        n = reverseBetween(head, 2, 4);
         while(n != null){
            System.out.print(" " + n.val);
            n = n.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode l = head;
        ListNode newHead = head;
        ListNode start = null;
        while (l != null) {
            count++;
            if (count < m) {
                if (count == m - 1) {
                    if (count == 0)
                        newHead = head;
                    else {
                        start = l;
                        newHead = l.next;
                    }
                }
                l = l.next;
            } else if (count >= m && count < n) {
                ListNode ll = l.next;
                l.next = ll.next;
                ll.next = newHead;
                newHead = ll;
            } else {
                break;
            }
        }
        if (start != null) {
            start.next = newHead;
            return head;
        } else {
            return newHead;
        }
    }
}
