package com.sjiyuan.list;

/**
 * @ClassName CircularList1_141
 * @Description TODO 环形链表1
 * @Author sjy
 * @Date 2020/1/17 0:01
 * @Version 1.0
 **/
public class CircularList1_141 {
    /**
     * 只是判断这个链表里是否有环(快慢指针，总会相遇)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
        }
        return false;
    }
}
