package com.sjiyuan.bit;

/**
 * @ClassName NumOfBits1_191
 * @Description TODO 位1的个数
 * @Author sjy
 * @Date 2020/1/9 22:57
 * @Version 1.0
 **/
public class NumOfBits1_191 {
    /**
     * n&n-1消除最后一位1的解法，见剑指offer
     * 负数也是成立的，因为负数-1，在二进制层面上也是-1，（补码）
     * 比如：1111 1001(-7)，减一后是1111 1000(-8)
     * 1111 1000(-8)，减一后是1111 0111(-9)
     * 位与后可以消除最后的1
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n = n & (n - 1);
        }
        return num;
    }

    public static void main(String args[]) {
        short a = Short.MAX_VALUE;
        //这个应该会转化成int
        System.out.println(Integer.toBinaryString(a + 1));
        NumOfBits1_191 n = new NumOfBits1_191();
        System.out.println("result:" + n.hammingWeight(-7));
    }
}
