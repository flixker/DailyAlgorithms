package me.fycus;

public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode n = head;
        boolean flag = false;
        while(n != null){
            ListNode slow = n;
            ListNode fast = n;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == n)
                    flag = true;
                if(slow == fast) {
                    if(flag)
                        return n;
                    break;
                }
            }
            flag = false;
            n = n.next;
        }
        return null;
    }
}
