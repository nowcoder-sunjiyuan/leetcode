package com.sjiyuan.math;

/**
 * @ClassName FindNthDigit_400
 * @Description TODO 第n个数字
 * @Author sjy
 * @Date 2020/2/4 19:48
 * @Version 1.0
 **/
public class FindNthDigit_400 {
    /**
     * 1 - 9：9个数字
     * 10 - 99：90个数字
     * 100 - 999：900个数字
     *
     * @param n
     * @return
     */
    public int findNthDigit(long n) {
        long number = 9;
        long numberPoint = 9;
        long prePoint = 0;
        int digit = 1;

        while (n > numberPoint) {
            digit++;
            number *= 10;
            prePoint = numberPoint;
            numberPoint += number * digit;
        }

        /**
         * 看距离前数字节点的个数
         */
        long inteval = n - prePoint;
        long result;
        if(digit == 1) result = inteval / digit;
        else result = (int) Math.pow(10, digit - 1) + (inteval / digit) - 1;

        String temp;
        if (inteval % digit == 0) {
            temp = String.valueOf(result);
            return temp.charAt(temp.length() - 1) - '0';
        } else {
            temp = String.valueOf(result + 1);
            return temp.charAt((int)(inteval % digit - 1)) - '0';
        }
    }


    public static void main(String args[]) {
        FindNthDigit_400 findNthDigit_400 = new FindNthDigit_400();
        //int i = 999999900;
        /*int i = 1;
        while(i <= 1000000){

            System.out.print(findNthDigit_400.findNthDigit(i));
            i++;
        }*/
        System.out.print(findNthDigit_400.findNthDigit(1000000000));
    }

}
