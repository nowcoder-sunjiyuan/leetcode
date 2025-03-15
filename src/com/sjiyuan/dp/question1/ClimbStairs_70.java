package com.sjiyuan.dp.question1;

/**
 * 爬楼梯
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        /**
         * f(n) = f(n-1) + f(n-2)
         * f(n-1)的次数，最后走1
         * f(n-2)的次数，最后走2
         */
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public int climbStairs2025(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int result = a + b;
        for (int i = 3; i < n + 1; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
