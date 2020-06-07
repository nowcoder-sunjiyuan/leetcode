package com.sjiyuan.offer;

/**
 * 斐波那契数列
 */
public class Subject10_1 {
    public int fib(int n) {

        int fb0 = 0;
        int fb1 = 1;
        if (n == 0) return fb0;
        if (n == 1) return fb1;

        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = (fb0 + fb1) % 1000000007;
            fb0 = fb1;
            fb1 = result;
        }
        return result;
    }
}
