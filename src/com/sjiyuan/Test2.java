package com.sjiyuan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-20 17:31
 */
public class Test2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[n];
        List<Long> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long result = 0;
            List<Long> temp2 = new ArrayList<>();
            //先判断自己
            if(array[i] <= target) {
                result++;
                temp2.add(array[i]);
            }else{
                dp[i] = 0;
                temp = temp2;
                continue;
            }
            for (long tmp : temp) {
                if ((tmp | array[i]) <= target) {
                    temp2.add(tmp | array[i]);
                    result++;
                }
            }

            dp[i] = result;
            temp = temp2;
        }
        long result = 0;
        for(long num : dp){
            result += num;
        }
        System.out.println(result % 1000000007);
    }


}
