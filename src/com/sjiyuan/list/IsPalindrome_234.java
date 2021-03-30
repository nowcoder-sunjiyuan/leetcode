package com.sjiyuan.list;

import java.util.List;

/**
 * @program: LeetCode
 * @description: 回文链表（自己写的）
 * @author: 孙济远
 * @create: 2021-03-25 00:52
 */
public class IsPalindrome_234 {
    // 思想：找到链表的中间位置，然后反转后面的链表
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode quick = head.next;
        if(quick == null) return true;
        ListNode slow = head;

        while(quick.next != null){
            quick = quick.next;
            slow = slow.next;
            // 说明是奇数
            if(quick.next == null) break;
            else quick = quick.next;
        }

        slow = slow.next;

        // 反转链表
        ListNode middle = slow.next;
        slow.next = null;
        if(middle == null){
            // 说明只有两个节点
            if(head.val == slow.val) return true;
            else return false;
        }else{
            ListNode behind = middle.next;
            while(behind != null){
                middle.next = slow;
                slow = middle;
                middle = behind;
                behind = behind.next;
            }

            middle.next = slow;

            while(middle != null){
                if(middle.val != head.val) return false;
                middle = middle.next;
                head = head.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        IsPalindrome_234 isPalindrome_234 = new IsPalindrome_234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome_234.isPalindrome(head);
        System.out.println(palindrome);
    }
}
