package com.sjiyuan.offer;

/**
 * 数值的整数次方pow函数
 */
public class Subject16 {

    /**
     * 正常的方法，但是要考虑0和负数
     * 超出时间限制
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow_1(double x, int n) {
        double result = 1;
        int temp;
        if (x == 0) return 0;
        if (n == 0 || x == 1) return 1;

        if (n < 0) temp = -n;
        else temp = n;

        while (temp != 0) {
            result = result * x;
            temp--;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * @param x
     * @param n
     * @return
     */
    public double myPow_2(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        //temp存的是n的绝对值
        long temp = n;
        if (n < 0) temp = -temp;

        double result = powRecursion(x, temp);

        if (n < 0) return 1 / result;
        else return result;
    }

    /**
     * X的7次方，等于X的3次方 * X的3次方 * X
     * X的8次方，等于X的4次方 * X的四次方
     *
     * @param x
     * @param n n > 0
     * @return
     */
    public double powRecursion(double x, long n) {

        if (n == 1) return x;

        //用移位代替除2
        if ((n & 1) == 1) {
            //n是奇数
            double temp = powRecursion(x, (n - 1) >> 1);
            return temp * temp * x;
        } else {
            //n是偶数
            double temp = powRecursion(x, n >> 1);
            return temp * temp;
        }

    }


    public static void main(String[] args) {

        int n = -2147483648;
        System.out.println(-n);


        /*Subject16 subject16 = new Subject16();
        System.out.println(subject16.myPow_2(1.000, -2147483648));*/
    }

}
