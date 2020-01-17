package com.sjiyuan.list;

/**
 * @ClassName DeleteDuplicateListNode_83
 * @Description TODO 删除排序链表的重复性元素1
 * @Author sjy
 * @Date 2020/1/11 16:23
 * @Version 1.0
 **/
public class DeleteDuplicateListNode_83 {
    /**
     * 如果他的下一个节点和这个节点相同，删除下一个节点，否则前进
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(head == null) return null;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {
        //ListNode head = new ListNode();

    }
}
