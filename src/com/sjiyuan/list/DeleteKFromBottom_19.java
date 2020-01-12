package com.sjiyuan.list;

/**
 * @ClassName DeleteKFromBottom_19
 * @Description TODO 删除链表的倒数第k个节点
 * @Author sjy
 * @Date 2020/1/12 21:20
 * @Version 1.0
 **/
public class DeleteKFromBottom_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head;
        ListNode behind = head;
        ListNode bbehind = null;

        for (int i = 0; i < n; i++) {
            if(front == null){
                return null;
            }
            front = front.next;
        }

        while(front != null){
            bbehind = behind;
            behind = behind.next;
            front = front.next;
        }
        /**
         * 如果bbheind是null，说明没有进while循环，此时删除的是头结点，否则删除behind节点就行了
         */
        if(bbehind == null){
            bbehind = behind.next;
            head = bbehind;
        }else{
            bbehind.next = behind.next;
        }


        return head;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        DeleteKFromBottom_19 delete = new DeleteKFromBottom_19();
        ListNode listNode = delete.removeNthFromEnd(head, 2);

        System.out.println(listNode);
    }
}
