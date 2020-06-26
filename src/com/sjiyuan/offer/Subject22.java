package com.sjiyuan.offer;

import com.sjiyuan.list.ListNode;

/**
 * 链表中的倒数第k个节点
 */
public class Subject22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode beh = head;

        for (int i = 1; i < k; i++) {
            if(beh == null) return null;
            beh = beh.next;
        }

        ListNode result = null;

        while(beh != null){
            result = pre;
            pre = pre.next;
            beh = beh.next;
        }
        return result;
    }
}
