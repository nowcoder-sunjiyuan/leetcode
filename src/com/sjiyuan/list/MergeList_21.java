package com.sjiyuan.list;

/**
 * @ClassName MergeList_21
 * @Description TODO 合并两个排序的链表
 * @Author sjy
 * @Date 2020/1/18 22:13
 * @Version 1.0
 **/
public class MergeList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result;
        ListNode pre;

        if (l1.val < l2.val) {
            result = l1;
            node1 = node1.next;
        } else {
            result = l2;
            node2 = node2.next;
        }
        //新链表的最后一个节点
        pre = result;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                pre = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                pre = node2;
                node2 = node2.next;
            }
        }

        if (node1 == null) {
            pre.next = node2;
        }
        if (node2 == null) {
            pre.next = node1;
        }

        return result;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeList_21 m = new MergeList_21();
        ListNode listNode = m.mergeTwoLists(l1, l2);



    }
}
