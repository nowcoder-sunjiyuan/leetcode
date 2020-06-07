package com.sjiyuan;

/**
 * @ClassName AddTwoNumbers_2
 * @Description TODO 两数相加
 * @Author sjy
 * @Date 2018/10/22 21:35
 * @Version 1.0
 **/
public class AddTwoNumbers_2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode tNode = null;
        int add = 0;        //进位
        int tag = 0;

        while (l1 != null && l2 != null) {

            if (tag == 0) {
                listNode = new ListNode((l1.val + l2.val + add) % 10);
                tNode = listNode;
                tag = 1;
            } else {
                tNode.next = new ListNode((l1.val + l2.val + add) % 10);
                tNode = tNode.next;
            }

            if ((l1.val + l2.val + add) >= 10) {
                add = 1;
            }else{
                add = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            change(tNode,l2,add);
        } else {
            change(tNode,l1,add);
        }
        return listNode;
    }

    public static void change(ListNode t, ListNode l, int add) {
        while (l != null) {
            t.next = new ListNode((l.val + add) % 10);

            if ((l.val + add) == 10) {
                add = 1;
            }else{
                add = 0;
            }
            t = t.next;
            l = l.next;
        }
        if(add == 1){
            t.next = new ListNode(1);
        }
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);
    }
}
