package com.sjiyuan.math;

/**
 * @ClassName Pow_50
 * @Description TODO 实现pow(x, n)函数，求x的n次方
 * @Author sjy
 * @Date 2020/1/10 16:24
 * @Version 1.0
 **/
public class Pow_50 {
    public double myPow(double x, int n) {
        //考虑0
        if (x == 0) return 0;
        if (n == 0) return 1;

        long power = n;

        /**
         * 如果x为正数，sign为true
         * 如果x为负数，sign为false
         */
        boolean sign = true;
        //考虑负数
        if (power < 0) {
            sign = false;
            power = -power;
        }

        double result = powRecursion(x, power);


        if (!sign) return 1 / result;
        else return result;
    }

    /**
     * 求x的n次方，这里n大于0
     *
     * @param x
     * @param n
     * @return
     */
    public double powRecursion(double x, long n) {

        /**
         * 当1次方时，返回x
         */
        if(n == 1) return x;

        /**
         * 判断n是奇数还是偶数
         */
        if ((n & 1) == 1) {
            //奇数
            double temp = powRecursion(x, (n - 1) >> 1);
            return temp * temp * x;
        } else {
            //偶数
            double temp = powRecursion(x, n >> 1);
            return temp * temp;
        }
    }


    public static void main(String args[]) {
        Pow_50 p = new Pow_50();
        System.out.println("答案：" + p.myPow(0.00001, 2147483647));
    }


    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow1(x, n / 2);
        double rest = myPow1(x, n % 2);
        return half * half * rest;

    }


}
