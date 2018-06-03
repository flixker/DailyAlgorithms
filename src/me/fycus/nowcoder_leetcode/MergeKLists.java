package me.fycus.nowcoder_leetcode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args){
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode l1 = new ListNode(1);
        lists.add(l1);

        ListNode head = mergeKLists(lists);
        ListNode n = head;
        while(n != null){
            System.out.print(" " + n.val);
            n = n.next;
        }
    }

    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for (ListNode l : lists) {
            if(l != null)
                queue.add(l);
        }

        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        while(!queue.isEmpty()){
            l.next = queue.poll();
            l = l.next;
            if(l.next != null)
                queue.add(l.next);
        }
        return dummy.next;
    }



    public static ListNode mergeKLists(ArrayList<ListNode> lists){
        ListNode hh = new ListNode(Integer.MIN_VALUE);
        ListNode l = hh;
        ListNode tem;
        ListNode min = hh;
        int minNum;
        int index = 0;
        int length = lists.size();
        while(min != null) {
            minNum = Integer.MAX_VALUE;
            min = null;
            for (int i = 0; i < length; i++) {
                tem = lists.get(i);
                if(tem == null){
                    continue;
                }
                if(tem.val < minNum){
                    minNum = tem.val;
                    index = i;
                    min = tem;
                }
            }
            if(min != null) {
                l.next = min;
                l = l.next;
                lists.add(index, min.next);
            }
        }
        return hh.next;
    }
}
