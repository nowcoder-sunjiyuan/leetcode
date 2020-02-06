package com.sjiyuan.list;

/**
 * @ClassName GetIntersectionNode_160
 * @Description TODO 相交链表找到第一个相交节点
 * @Author sjy
 * @Date 2020/2/6 17:02
 * @Version 1.0
 **/
public class GetIntersectionNode_160 {
    /**
     * 时间 O(m+n) 统计两个链表长度，然后在长链表到结尾长度与短链表相同处开始循环
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        while (lengthA > lengthB) {
             headA = headA.next;
             lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
