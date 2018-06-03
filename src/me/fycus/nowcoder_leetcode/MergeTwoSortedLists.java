package me.fycus.nowcoder_leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        ListNode n = hh;
        while(l1 != null || l2 != null){
            if(l1 == null){
                n.next = l2;
                break;
            }else if(l2 == null){
                n.next = l1;
                break;
            }else if(l1.val < l2.val){
                n.next = l1;
                l1 = l1.next;
                n = n.next;
            }else{
                n.next = l2;
                l2 = l2.next;
                n = n.next;
            }
        }
        return hh.next;
    }
}
