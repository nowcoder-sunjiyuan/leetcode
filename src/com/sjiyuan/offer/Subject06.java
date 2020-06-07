package com.sjiyuan.offer;

import com.sjiyuan.list.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Subject06 {
    /**
     * 从头到尾遍历链表，放进栈里面
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            result[i] = stack.pop();
            i++;

        }
        return result;
    }
}
