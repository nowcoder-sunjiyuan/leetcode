package com.sjiyuan.math;

/**
 * @ClassName Ugly_263
 * @Description TODO 判断是不是丑数
 * @Author sjy
 * @Date 2020/2/4 22:35
 * @Version 1.0
 **/
public class Ugly_263 {

    public boolean isUgly(int num) {

        if (num <= 0) return false;

        while (num % 2 == 0) {
            num = num / 2;
        }

        while (num % 3 == 0) {
            num = num / 3;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }

        if (num == 1) return true;
        else return false;
    }

    public static void main(String args[]) {
        Ugly_263 ugly_263 = new Ugly_263();
        System.out.println("答案：" + ugly_263.isUgly(14));
    }

}
