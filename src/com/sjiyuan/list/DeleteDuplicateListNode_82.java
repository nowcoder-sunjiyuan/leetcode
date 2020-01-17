package com.sjiyuan.list;

/**
 * @ClassName DeleteDuplicateListNode_82
 * @Description TODO 删除排序链表重复性元素2
 * @Author sjy
 * @Date 2020/1/14 17:38
 * @Version 1.0
 **/
public class DeleteDuplicateListNode_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode result = head;

        //永远指向pre的前一个节点
        ListNode temp = null;

        ListNode pre = head;
        ListNode now = head.next;

        while (now != null) {
            //如果俩节点相同，now就往后退
            if (pre.val == now.val) {
                now = now.next;
            } else {
                if (pre.next == now) {
                    //说明相邻的两个不相同，不需要删除
                    temp = pre;
                }else{
                    //说明pre到now的前一个都应该删掉
                    if(temp == null){
                        result = now;
                    }else{
                        //如果不是开头，就将pre的前一个元素的下一位置为now就好了，pre变成now，随后将now向后移动一位
                        temp.next = now;
                    }
                }
                pre = now;
                now = now.next;
            }
        }
        //退出后，如果pre的下一位不是null，说明pre到最后是重复的
        if(pre.next != null){
            if(temp == null){
                result = null;
            }else{
                temp.next = null;
            }
        }
        return result;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        //head.next.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next.next = new ListNode(5);
        DeleteDuplicateListNode_82 d = new DeleteDuplicateListNode_82();
        ListNode listNode = d.deleteDuplicates(head);
        System.out.println("结束");

    }
}