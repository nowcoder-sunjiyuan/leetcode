package com.sjiyuan.stack;

import java.util.Stack;

/**
 * @ClassName ImplementationQueue_232
 * @Description TODO 用栈实现队列（双栈法）（剑指offer）
 * @Author sjy
 * @Date 2020/1/6 22:26
 * @Version 1.0
 **/
public class ImplementationQueue_232 {
    private Stack<Integer> stack_1;
    private Stack<Integer> stack_2;

    /**
     * Initialize your data structure here.
     */
    public ImplementationQueue_232() {
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack_1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack_2.isEmpty()) {
            return stack_2.pop();
        } else {
            while (!stack_1.isEmpty()) {
                Integer temp = stack_1.pop();
                stack_2.push(temp);
            }
            return stack_2.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack_2.isEmpty()) {
            return stack_2.peek();
        } else {
            while (!stack_1.isEmpty()) {
                Integer temp = stack_1.pop();
                stack_2.push(temp);
            }
            return stack_2.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if(stack_1.isEmpty() && stack_2.isEmpty()) return true;
        else return false;
    }
}
