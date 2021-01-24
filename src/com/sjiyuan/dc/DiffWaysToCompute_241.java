package com.sjiyuan.dc;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 为运算表达式设计优先级
 * @author: 孙济远
 * @create: 2021-01-22 10:15
 */
public class DiffWaysToCompute_241 {
    private static final List<Character> operator = Arrays.asList('+', '-', '*');

    // 分治的算法
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> result = new ArrayList<>();

        //如果是数字，直接返回吧
        if (isNumeric(input)) {
            result.add(Integer.parseInt(input));
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (operator.contains(input.charAt(i))) {
                // 说明是运算符
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        if(input.charAt(i) == '+') result.add(l + r);
                        if(input.charAt(i) == '-') result.add(l - r);
                        if(input.charAt(i) == '*') result.add(l * r);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param num
     * @return
     */
    public static boolean isNumeric(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < '0' || num.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DiffWaysToCompute_241 diffWaysToCompute_241 = new DiffWaysToCompute_241();
        List<Integer> integers = diffWaysToCompute_241.diffWaysToCompute("2-1-1");
        integers.forEach(System.out::println);
    }
}
