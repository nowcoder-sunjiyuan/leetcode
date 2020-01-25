package com.sjiyuan.stack;

import java.util.Stack;

/**
 * @ClassName MinStack_155
 * @Description TODO 最小栈
 * @Author sjy
 * @Date 2020/1/25 22:19
 * @Version 1.0
 **/
public class MinStack_155 {

    /**
     * 剑指offer的方法，辅助栈添加最小的数值
     */
    private Stack<Integer> stack;
    private Stack<Integer> assist;

    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Stack<>();
        assist = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(assist.peek() == null || assist.peek() >= x){
            assist.add(x);
        }else{
            assist.add(assist.peek());
        }
    }

    public void pop() {
        stack.pop();
        assist.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return assist.peek();
    }
}
