package com.sjiyuan.math;

/**
 * @ClassName CountDigitOne_233
 * @Description TODO 数字一的个数
 * @Author sjy
 * @Date 2020/2/2 23:37
 * @Version 1.0
 **/
public class CountDigitOne_233 {
    /**
     * 数学法（见leetcode官方教程）(太恶心了)
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        //次数
        long count = 1;

        //数量
        int sum = 0;
        while (count <= n) {
            long highPosition = n / (count * 10);
            long data = n % (count * 10);

            //算data中,当前位会包含多少的1
            long min = Math.min(Math.max(data - count + 1, 0), count);
            sum += highPosition * count + min;

            count *= 10;

        }


        return sum;
    }

    public static void main(String args[]) {
        CountDigitOne_233 countDigitOne_233 = new CountDigitOne_233();
        System.out.println(countDigitOne_233.countDigitOne(100));
    }
}
