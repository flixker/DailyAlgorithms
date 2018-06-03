package me.fycus.nowcoder_leetcode;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        Set<Integer> set = new HashSet<>();
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        hh.next = head;
        ListNode last = hh;
        ListNode n = head;
        while(n != null){
            if(set.contains(n.val)){
                last.next = n.next;
            }else{
                set.add(n.val);
                last = n;
            }
            n = n.next;
        }
        return hh.next;
    }
}
