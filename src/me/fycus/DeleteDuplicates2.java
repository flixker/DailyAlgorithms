package me.fycus;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head){
        ListNode n = head;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dupli = new HashSet<>();
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        hh.next = head;
        ListNode last = hh;
        while(n != null){
            if(set.contains(n.val)){
                last.next = n.next;
                dupli.add(n.val);
            }else{
                set.add(n.val);
                last = n;
            }
            n = n.next;
        }
        n = head;
        last = hh;
        while(n != null){
            if(dupli.contains(n.val)){
                last.next = n.next;
            }else{
                last = n;
            }
            n = n.next;
        }
        return hh.next;
    }
}
