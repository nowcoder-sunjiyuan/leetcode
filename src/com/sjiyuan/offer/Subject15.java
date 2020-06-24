package com.sjiyuan.offer;

/**
 * 二进制中1的个数
 */
public class Subject15 {
    /**
     * 从1开始，通过右移后，再与数字想与，判断数字每一位的数字是否是1
     *
     * @param n
     * @return
     */
    public int hammingWeight_1(int n) {
        int result = 0;
        int flag = 1;
        while (n >= flag) {
            if ((n & flag) == flag) result++;
            flag = flag << 1;
        }
        return result;
    }

    /**
     * 数字减1后，最后一位1变0，1后0全变1。再与原数想与后相当于最后的一位1变成0。
     * 重复上述过程，直到等于0后，重复了几次，就有多少1
     *
     * @param n
     * @return
     */
    public int hammingWeight_2(int n) {
        int result = 0;
        while (n != 0) {
            n = ((n - 1) & n);
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        Subject15 subject15 = new Subject15();
        System.out.println(subject15.hammingWeight_2(31));
    }
}
