package com.sjiyuan.stack;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 字符串解码
 * @author: 孙济远
 * @create: 2021-03-20 00:03
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                StringBuilder sb = new StringBuilder();
                int j = i;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    sb.append(s.charAt(j));
                    j++;
                }
                i = j - 1;
                stack.push(sb.toString());
            }else if('[' == s.charAt(i) || Character.isLetter(s.charAt(i))){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                StringBuilder sb = new StringBuilder();
                StringBuilder temp = new StringBuilder();
                while(true){
                    String c = stack.pop();
                    if(c.equals("[")) break;
                    sb.insert(0, c);
                }

                int num = Integer.parseInt(stack.pop());
                while(num != 0){
                    temp.insert(0,sb.toString());
                    num--;
                }
                stack.push(temp.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 decodeString_394 = new DecodeString_394();
        String s = decodeString_394.decodeString("100[leetcode]");
        System.out.println(s);
    }
}
