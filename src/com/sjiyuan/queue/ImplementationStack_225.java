package com.sjiyuan.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ImplementationStack_225
 * @Description TODO 队列实现栈
 * @Author sjy
 * @Date 2020/1/7 22:14
 * @Version 1.0
 **/
public class ImplementationStack_225 {
    /**
     * 双队列实现栈
     */
    private Queue<Integer> queue_1;
    private Queue<Integer> queue_2;

    /**
     * Initialize your data structure here.
     */
    public ImplementationStack_225() {
        queue_1 = new LinkedList<>();
        queue_2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue_1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = queue_1.size();
        for (int i = 1; i < size; i++) {
            Integer poll = queue_1.poll();
            queue_2.offer(poll);
        }
        Queue<Integer> temp = queue_1;
        queue_1 = queue_2;
        queue_2 = temp;
        //拆装箱会出现空指针，但题目假设不会出现这种情况
        return queue_2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int size = queue_1.size();
        for (int i = 1; i < size; i++) {
            Integer poll = queue_1.poll();
            queue_2.add(poll);
        }

        Queue<Integer> temp = queue_1;
        queue_1 = queue_2;
        queue_2 = temp;

        Integer data = queue_2.poll();
        if (data != null) {
            queue_1.offer(data);
        }
        //拆装箱会出现空指针，但题目假设不会出现这种情况
        return data;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue_1.isEmpty();
    }


    public static void main(String args[]) {
        ImplementationStack_225 i = new ImplementationStack_225();
        i.push(1);
        i.push(2);
        i.push(3);
        System.out.println(i.top());

    }
}
