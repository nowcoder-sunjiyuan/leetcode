package com.sjiyuan.math;

/**
 * @ClassName Ugly2_264
 * @Description TODO 丑数2，返回第n个丑数
 * @Author sjy
 * @Date 2020/2/4 23:22
 * @Version 1.0
 **/
public class Ugly2_264 {
    public int nthUglyNumber(int n) {
        int[] result = new int[1700];
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;

        int twoPoint = 1;
        int threePoint = 1;
        int fivePoint = 0;

        int nextTwoData;
        int nextThreeData;
        int nextFiveData;

        int i = 3;
        while (i < n) {

            while((nextTwoData = result[twoPoint] * 2) <= result[i - 1]){
                twoPoint++;
            }
            while((nextThreeData = result[threePoint] * 3) <= result[i - 1]){
                threePoint++;
            }
            while((nextFiveData = result[fivePoint] * 5) <= result[i - 1]){
                fivePoint++;
            }

            boolean two = true;
            boolean three = false;
            boolean five = false;

            int min = nextTwoData;

            if (nextThreeData < min) {
                min = nextThreeData;
                three = true;
                two = false;
            }

            if (nextFiveData < min) {
                five = true;
                two = false;
                three = false;
            }

            if (two) {
                result[i] = nextTwoData;
                twoPoint++;
            }

            if (three) {
                result[i] = nextThreeData;
                threePoint++;
            }

            if(five) {
                result[i] = nextFiveData;
                fivePoint++;
            }

            i++;
        }

        return result[n - 1];
    }

    public static void main(String args[]){
        Ugly2_264 ugly2_264 = new Ugly2_264();
        System.out.println(ugly2_264.nthUglyNumber(7));
    }
}
