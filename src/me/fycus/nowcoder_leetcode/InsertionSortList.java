package me.fycus.nowcoder_leetcode;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public static void main(String[] args){

    }
    public ListNode insertionSortList(ListNode head){
        if(head == null)
            return null;
        ListNode pseudo = new ListNode(Integer.MIN_VALUE);
        pseudo.next = head;
        ListNode it = head;
        while(it != null && it.next != null){
            ListNode tmp = it.next;
            // 寻找下一个节点tmp合适的位置
            ListNode itt = pseudo.next;
            ListNode last = pseudo;
            // 插入位置应该在last之后
            while(itt != tmp && itt.val <= tmp.val){
                last = itt;
                itt = itt.next;
            }
            // 先取出tmp
            it.next = tmp.next;
            // 再插到last后
            tmp.next = last.next;
            last.next = tmp;
            // 移动it
            if(it == tmp)
            it = tmp;
        }
        return pseudo.next;
    }
}
