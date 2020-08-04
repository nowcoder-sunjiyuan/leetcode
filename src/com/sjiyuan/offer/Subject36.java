package com.sjiyuan.offer;

/**
 * 递归方式实现
 * 每一个节点左子树都比它小，右子树都比它大。
 * 这个节点就是处于中间
 */
public class Subject36 {

    private Node head;
    private Node listTail;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        recursion(root);
        head.left = listTail;
        listTail.right = head;
        return head;
    }

    /**
     * 递归访问Node，将其变换成双向链表
     *
     * @param node      当前节点
     */
    public void recursion(Node node) {
        if (node == null) return;

        if (node.left != null) {
            recursion(node.left);
        }
        /**
         * 将本节点连在链表最后节点的后面
         * 当然要考虑第一个节点的情况，此时链表的最后节点为null
         */
        if (listTail != null) {
            listTail.right = node;
        } else {
            head = node;
        }

        node.left = listTail;
        listTail = node;

        if (node.right != null) {
            recursion(node.right);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Subject36 subject36 = new Subject36();
        Node node = subject36.treeToDoublyList(root);
        System.out.println(1);
    }
}
