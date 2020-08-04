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

        /**
         * 写复制的节点的random，其刚好是原链表节点的random的后一个节点（复制出来的）
         */
        n = head;
        while(n != null){
            temp = n.next;
            if(n.random == null) {
                temp.random = null;
            }else{
                temp.random = n.random.next;
            }

            n = n.next.next;
        }

        /**
         * 奇数位组成的链表是原节点
         * 偶数位的节点组成新复制的链表
         */
        Node result = head.next;
        n = head;
        temp = head.next;
        while(n != null){
            /**
             * 在最后节点，temp.next是null，所以把最后的节点额外判断赋值
             */
            if(n.next.next == null){
                n.next = null;
                temp.next = null;
            }else{
                n.next = n.next.next;
                temp.next = temp.next.next;
            }

            n = n.next;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String args[]){
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyRandomList_138 copyRandomList_138 = new CopyRandomList_138();
        Node node = copyRandomList_138.copyRandomList(node1);
    }
}
