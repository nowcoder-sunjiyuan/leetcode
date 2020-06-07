package com.sjiyuan.offer;

/**
 * 青蛙跳台问题
 * 1个台阶：1种
 * 2个台阶：2种
 * n个台阶，分成先一个台阶，然后再跳n-1个台阶。或者先两个台阶，然后再跳n-2个台阶（斐波那契数列）
 */
public class Subject10_2 {
    public int numWays(int n) {
        int fb1 = 1;
        int fb2 = 2;
        if (n == 1) return fb1;
        if (n == 2) return fb2;

        int result = 1;

        for (int i = 3; i <= n; i++) {
            result = (fb1 + fb2) % 1000000007;
            fb1 = fb2;
            fb2 = result;
        }
        return result;
    }
}
