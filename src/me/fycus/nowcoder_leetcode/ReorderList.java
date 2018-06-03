package me.fycus.nowcoder_leetcode;


public class ReorderList {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        reorderList(n1);
        ListNode i = n1;
        while(i != null){
            System.out.print(" " + i.val);
            i = i.next;
        }
    }

    public static void reorderList(ListNode head){
        if(head == null){
            return;
        }
        //快慢指针，偶数时慢指针在后位
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;
        while(fast != null && fast.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        last.next = null;
        if(slow == head){
            return;
        }

        //反序
        ListNode halfHead = slow;
        while(slow.next != null){
            ListNode nn = slow.next;
            slow.next = nn.next;
            nn.next = halfHead;
            halfHead = nn;
        }

        //交叉插入
        ListNode n = head;
        ListNode m = halfHead;
        ListNode lastM = null;
        while(n != null){
            ListNode nn = n.next;
            ListNode mm = m.next;
            n.next = m;
            if(nn != null) {
                m.next = nn;
            }
            n = nn;
            m = mm;
        }
    }
}
