package com.sjiyuan.list;

/**
 * @ClassName DeleteListNode_237
 * @Description TODO 删除链表中的节点
 * @Author sjy
 * @Date 2020/1/11 15:54
 * @Version 1.0
 **/
public class DeleteListNode_237 {
    /**
     * 题目前提，node指向的节点不是尾结点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
