package me.fycus.nowcoder_leetcode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode n = head;
        RandomListNode nn = null;

        //复制节点，将新节点放在原节点后一个
        while(n != null){
            nn = n.next;
            n.next = new RandomListNode(n.label);
            n.next.next = nn;
            n = nn;
        }

        //复制随机指针
        n = head;
        while(n != null){
            RandomListNode nr = n.random;
            if(nr != null){
                n.next.random = nr.next;
            }
            n = n.next.next;
        }

        //将新链表分离出来，并还原链表
        n = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode m = newHead;
        while(n != null){
            nn = n.next.next;
            m.next = n.next;
            n.next = nn;
            m = m.next;
            n = n.next;
        }
        return newHead.next;
    }
}
