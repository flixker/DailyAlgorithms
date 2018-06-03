package me.fycus.nowcoder_leetcode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        int count = 0;
        ListNode cur = head;
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        hh.next = head;
        ListNode last = hh;

        while(cur != null){
            count++;
            if(count == k){
                ListNode partHead = last.next;
                while(--count > 0) {
                    ListNode tem = partHead.next;
                    partHead.next = tem.next;
                    tem.next = last.next;
                    last.next = tem;
                }
                last = partHead;
                cur = partHead;
            }
            cur = cur.next;
        }

        return hh.next;
    }
}
