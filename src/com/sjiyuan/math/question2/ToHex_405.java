package com.sjiyuan.math.question2;

/**
 * @program: LeetCode
 * @description: 数字转换为十六进制数
 * @author: 孙济远
 * @create: 2021-02-03 14:43
 */
public class ToHex_405 {
    /*public String toHex(int num) {
        StringBuilder result = new StringBuilder();
        boolean tag = false;
        if(num < 0){
            tag = true;
            num = -num;
        }
        while (num > 16) {
            int t = num % 16;
            char c = bitToHex(t);
            num = num / 16;
            result.insert(0, c);
        }
        char t1 = bitToHex(num);
        result.insert(0, t1);
        if(tag) result.insert(0, "-");
        return result.toString();
    }
    */

    public char bitToHex(int num) {
        if (num >= 10) return (char) ('a' + (num - 10));
        else return (char) ('0' + num);
    }

    /**
     * 转化为32位的二进制，再转化为16进制
     * 其实本题负数转化为十六进制后，按照补码来展示的
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        StringBuilder result = new StringBuilder();
        if (num == 0) return "0";
        while (num != 0) {
            //每4位转化为一个16进制的数
            int t = num & 0xf;
            char c = bitToHex(t);
            result.insert(0, c);
            // 注意这是逻辑右移
            num = num >>> 4;
        }
        return result.toString();
    }
}
