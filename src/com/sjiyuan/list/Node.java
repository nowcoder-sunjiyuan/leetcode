package com.sjiyuan.list;

/**
 * @ClassName Node
 * @Description TODO 带随机指针的链表节点
 * @Author sjy
 * @Date 2020/1/28 22:13
 * @Version 1.0
 **/
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
