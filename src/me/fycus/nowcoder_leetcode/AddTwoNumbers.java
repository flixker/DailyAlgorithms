package me.fycus.nowcoder_leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int add = 0;
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        while(l1 != null && l2 != null){
            l.next = new ListNode(l1.val + l2.val + add);
            l = l.next;
            if(l.val >= 10){
                l.val = l.val % 10;
                add = 1;
            }else
                add = 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            while(l1 != null) {
                l.next = new ListNode(l1.val + add);
                l = l.next;
                if (l.val >= 10) {
                    l.val = l.val % 10;
                    add = 1;
                }else
                    add = 0;
                l1 = l1.next;
            }
        }else if(l2 != null){
            while(l2 != null) {
                l.next = new ListNode(l2.val + add);
                l = l.next;
                if (l.val >= 10) {
                    l.val = l.val % 10;
                    add = 1;
                }else
                    add = 0;
                l2 = l2.next;
            }       }
        if(add == 1){
            l.next = new ListNode(1);
        }
        return dummy.next;
    }
}
