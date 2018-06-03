package me.fycus.nowcoder_leetcode;

public class SortList {
    public static void main(String[] args){
        ListNode head = new ListNode(10);
        ListNode tmp = head;
        for(int i = 3; i > 0; i--){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        SortList sort = new SortList();
        ListNode result = sort.sortList(head.next);
        while(result.next != null) {
            result = result.next;
            System.out.print(result.val + " ");
        }
    }
    public ListNode sortList(ListNode head){
        if(head == null)
            return null;
        return merge(head);
    }
    private ListNode merge(ListNode x) {
        if(x == null)
            return null;
        if(x.next == null)
            return x;

        ListNode slow = x;
        ListNode fast = x;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rear = merge(slow.next);
        slow.next = null;
        ListNode front = merge(x);

        ListNode result = new ListNode(0);
        ListNode tmp = result;
        while (front != null && rear != null) {
            if (front.val < rear.val) {
                tmp.next = front;
                front = front.next;
            } else {
                tmp.next = rear;
                rear = rear.next;
            }
            tmp = tmp.next;
        }
        if (front == null)
            tmp.next = rear;
        else
            tmp.next = front;

        return result.next;
    }
}
