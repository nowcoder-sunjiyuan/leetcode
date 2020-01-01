package com.sjiyuan;

/**
 * @ClassName Reverse_7
 * @Description TODO 将32位有符号整数反转
 * @Author sjy
 * @Date 2018/10/30 21:48
 * @Version 1.0
 **/
public class Reverse_7 {
    public static int reverse(int x) {

        int i,j = 0,k = 0;
        String xs = String.valueOf(x);
        char[] nums = new char[32];

        for(i = xs.length()-1,j = 0; i >= 0; i--,j++){

            if(xs.charAt(i) == '-'){
                break;
            }
            nums[j] = xs.charAt(i);
        }
        String temp = String.valueOf(nums);
        Double Tdouble = Double.valueOf(temp);
        if(x < 0){
            Tdouble = -Tdouble;
            if(Tdouble < -2147483648){
                return 0;
            }
        }

        if(Tdouble > 2147483647){
            return 0;
        }

        double a =  Tdouble;
        int b = (int)a;
        return b;
    }
}
