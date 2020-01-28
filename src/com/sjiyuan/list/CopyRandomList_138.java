package com.sjiyuan.list;

/**
 * @ClassName CopyRandomList_138
 * @Description TODO 复制带随机指针的链表
 * @Author sjy
 * @Date 2020/1/28 22:12
 * @Version 1.0
 **/
public class CopyRandomList_138 {
    /**
     * 剑指offer的解法，见书189页，不用多余空间，快速解决随机指针的问题
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node n = head;
        Node temp;
        /**
         * 给每一个节点后面都加上复制的节点
         */
        while (n != null) {
            temp = new Node(n.val);
            temp.next = n.next;
            n.next = temp;

            n = temp.next;
        }

        n = head;
        while(n != null){
            temp = n.next;
            temp.random = n.random.next;

            n = temp.next;
        }

        Node result = head.next;
        n = result;
        while(n != null){
            if(n.next != null){
                n.next = n.next.next;
            }

            n = n.next;
        }


        return result;
    }
}
