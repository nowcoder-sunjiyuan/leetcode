package com.sjiyuan.stack;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 有效的括号
 * @author: 孙济远
 * @create: 2021-03-19 23:12
 */
public class isValid_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && isCorrespond(stack.peek(),s.charAt(i))){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public boolean isCorrespond(char c, char b){
        return (c == '(' && b == ')') || (c == '{' && b == '}') || (c == '[' && b == ']');
    }

    public static void main(String[] args) {
        isValid_20 isValid_20 = new isValid_20();
        isValid_20.isValid("()");
    }
}
