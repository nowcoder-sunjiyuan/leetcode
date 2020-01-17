package com.sjiyuan.list;

/**
 * @ClassName ListMiddle_876
 * @Description TODO 链表的中间节点
 * @Author sjy
 * @Date 2020/1/16 22:22
 * @Version 1.0
 **/
public class ListMiddle_876 {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        /**
         * 指明fast是走一步结束的，还是走两步结束的
         * false：代表走两步
         * true：代表走了一步
         */
        boolean tag = false;

        while(fast != null){
            fast = fast.next;
            if(fast == null) {
                tag = true;
                break;
            }
            else fast = fast.next;
            slow = slow.next;
        }
        if(tag) return slow.next;
        else return slow;
    }
}
