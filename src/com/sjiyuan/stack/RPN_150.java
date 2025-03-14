package com.sjiyuan.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RPN_150 {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        RPN_150 s = new RPN_150();
        s.evalRPN(tokens);
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                deque.push(Integer.parseInt(tokens[i]));
            } else {
                Integer right = deque.pop();
                Integer left = deque.pop();
                Integer re = ca(left, right, tokens[i]);
                deque.push(re);
            }
        }
        return deque.pop();
    }

    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer ca(Integer a, Integer b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            return a / b;
        }
        throw new RuntimeException();
    }

}
