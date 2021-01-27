package com.sjiyuan.bit;

/**
 * @program: LeetCode
 * @description: 两个数字对应二进制位不同的位置的数目
 * @author: 孙济远
 * @create: 2021-01-27 11:47
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int t1 = x ^ y;

        //StringBuilder str = new StringBuilder();
        int result = 0;
        /**
         * 将十进制数转化为二进制
         */
        for (int i = 0; i < 31; i++) {
            int i1 = t1 & 1;
            if (i1 == 1) result++;
            //str.insert(0, i1);
            t1 = t1 >> 1;
        }

        //System.out.println(str);
        return result;
    }

    public static void main(String[] args) {
        HammingDistance_461 hammingDistance_461 = new HammingDistance_461();
        System.out.println(hammingDistance_461.hammingDistance(1, 4));
    }
}
