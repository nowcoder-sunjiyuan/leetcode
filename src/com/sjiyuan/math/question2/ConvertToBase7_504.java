package com.sjiyuan.math.question2;

/**
 * @program: LeetCode
 * @description: 转化为7进制数
 * @author: 孙济远
 * @create: 2021-01-29 18:56
 */
public class ConvertToBase7_504 {

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean tag = false;
        if(num < 0){
            tag = true;
            num = -num;
        }

        while (num >= 7) {
            int current = num % 7;
            num = num / 7;
            sb.insert(0, current);
        }
        sb.insert(0, num);
        if(tag) sb.insert(0, "-");
        return sb.toString();
    }
}
