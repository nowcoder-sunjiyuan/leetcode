package com.sjiyuan.offer;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class Subject09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Subject09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.empty()) return stack2.pop();

        while (!stack1.empty()) {
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        if(stack2.empty()) return -1;
        return stack2.pop();
    }
}
