package com.sjiyuan.list;

/**
 * @ClassName CircularList2_142
 * @Description TODO 环形链表2
 * @Author sjy
 * @Date 2020/1/18 20:31
 * @Version 1.0
 **/
public class CircularList2_142 {
    /**
     * 返回链表开始入环的第一个节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        /**
         * 1.先判断链表中是否有环
         * 2.求出环中节点的数目n
         * 3.相距n的节点，往前走，相遇即是入口节点
         */
        //表示是否有环
        boolean tag = false;
        //环中数据的数量
        int cycleNum = 0;


        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;

            //说明存在环
            if (slow == fast) {
                tag = true;
                break;
            }
        }


        if (tag) {
            //先看这个环有多少个数目
            fast = fast.next;
            cycleNum++;
            while (fast != slow) {
                fast = fast.next;
                cycleNum++;
            }


            //双指针找到环的入口
            fast = head;
            while (cycleNum != 0) {
                fast = fast.next;
                cycleNum--;
            }
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        } else {
            return null;
        }

    }
}
