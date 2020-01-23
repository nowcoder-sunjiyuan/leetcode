package com.sjiyuan.list;

/**
 * @ClassName ReversalList_92
 * @Description TODO 反转链表2
 * @Author sjy
 * @Date 2020/1/23 10:40
 * @Version 1.0
 **/
public class ReversalList_92 {

    /**
     * 206题是反转整个链表，此题调用206题
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) return null;

        int i;

        ListNode front = head;
        ListNode back;

        //指向需要反转的链表的前一个节点
        ListNode start = null;
        //指向需要反转链表的后一个节点
        ListNode end = null;

        //循环结束后，front指向需要反转链表的头
        for (i = 1; i < m; i++) {
            start = front;
            front = front.next;
        }

        //循环结束后，back指向需要反转链表的最后一个节点，end指向反转链表的最后一个节点的后一个节点
        /**
         * i = 2,back指向2
         * i = 3,back指向3
         * i = 4,back指向4
         */
        for (back = front; i < n; i++) {
            back = back.next;
        }
        end = back.next;
        back.next = null;

        ListNode temp = front;
        ReversalList_206 reversalList_206 = new ReversalList_206();

        if (start == null) {
            head = reversalList_206.reverseList(front);
        } else {
            start.next = reversalList_206.reverseList(front);
        }
        temp.next = end;

        return head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReversalList_92 reversalList_92 = new ReversalList_92();
        System.out.println(reversalList_92.reverseBetween(head, 2, 2));
    }
}
