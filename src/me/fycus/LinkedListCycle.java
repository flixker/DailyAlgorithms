package me.fycus;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(hasCycle(n1));
    }

    //slow and fast
    public boolean hasCycle2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    //origin
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode n = head;
        while(n != null){
            if(!nodes.add(n)){
                return true;
            }
            n = n.next;
        }
        return false;
    }
}
