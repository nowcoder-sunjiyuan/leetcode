package com.sjiyuan.offer;

import com.sjiyuan.list.ListNode;

/**
 * 删除链表节点
 */
public class Subject18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode middle = head;
        while (middle.val != val) {
            pre = middle;
            middle = middle.next;
        }
        if (pre != null) {
            pre.next = middle.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
