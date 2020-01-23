package com.sjiyuan.list;

/**
 * @ClassName ReversalList_206
 * @Description TODO 反转链表1
 * @Author sjy
 * @Date 2020/1/18 21:57
 * @Version 1.0
 **/
public class ReversalList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode front = head;

        ListNode middle = head.next;

        head.next = null;
        if (middle == null) return head;

        ListNode back = middle.next;

        while (back != null) {
            middle.next = front;

            front = middle;
            middle = back;

            back = back.next;
        }

        //当back为null的时候，只需要把最后的middle指向front
        middle.next = front;

        return middle;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReversalList_206 r = new ReversalList_206();
        ListNode listNode = r.reverseList(head);

    }
}
