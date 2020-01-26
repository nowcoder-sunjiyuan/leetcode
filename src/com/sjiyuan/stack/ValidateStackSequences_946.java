package com.sjiyuan.stack;

import java.util.Stack;

/**
 * @ClassName ValidateStackSequences_946
 * @Description TODO 验证栈序列
 * @Author sjy
 * @Date 2020/1/26 11:35
 * @Version 1.0
 **/
public class ValidateStackSequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int length = pushed.length;
        if (pushed.length != popped.length) return false;

        int i = 0, j = 0;
        while (true) {
            if (stack.empty()) {
                stack.push(pushed[i]);
                i++;
            }

            /**
             * 不会出现栈顶为空的情形，因为上面已经保证了pushed和popped的长度相等
             * 如果pop之后，栈为空，且i已经为length，不会再循环，j一定为length，则返回true
             */
            if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
                if (j == length) return true;
            } else {
                //在栈最上面的元素与序列需要的不符，此时pushed已经全部压栈了，这时肯定不能得到输出序列
                if (i == length) return false;
                stack.push(pushed[i]);
                i++;
            }
        }
    }

    public static void main(String args[]) {
        int pushed[] = {1, 2, 3, 4, 5};
        int popoed[] = {4, 5, 3, 2, 1};
        ValidateStackSequences_946 validateStackSequences_946 = new ValidateStackSequences_946();
        System.out.println("答案：" + validateStackSequences_946.validateStackSequences(pushed, popoed));
    }
}
