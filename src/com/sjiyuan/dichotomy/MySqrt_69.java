package com.sjiyuan.dichotomy;

/**
 * 求数据开平方
 */
public class MySqrt_69 {
    /**
     * 我的方法:二分法去找
     * 问题：current * current的乘积会超出范围
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int current = (start + end) / 2;
            long sqrt = current * current;
            if (sqrt == x) return current;
            else if (sqrt < x) {
                start = current;
            } else {
                end = current;
            }
        }
        return start;
    }

    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public int mySqrt_2(int x) {
        int start = 0;
        int end = x;
        /**
         * 只有1的情况是特殊的
         */
        if (x == 1) return 1;
        while (start + 1 < end) {
            /**
             * 注意：start要从0开始，不能从1，因为有可能start + end会超出int的范围
             */
            int current = (start + end) / 2;
            /**
             * 要用除法来判断，而不是current * current来和x比较，因为current * current会超出int的范围
             */
            int temp = x / current;
            if (temp == current) {
                return current;
            } else if (temp < current) {
                // 此时说明current大了，end变current
                end = current;
            } else {
                // 此时说明current小了，start变current
                start = current;
            }
        }
        //start + 1 = end的时候，说明结果start - end之间，此时取小的那个
        return start;
    }


    public static void main(String[] args) {
        MySqrt_69 mySqrt_69 = new MySqrt_69();
        System.out.println(mySqrt_69.mySqrt_2(8));
    }
}
