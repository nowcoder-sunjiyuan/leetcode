package com.sjiyuan.dp.question4;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 完全平方数
 * @author: 孙济远
 * @create: 2021-01-28 16:18
 */
public class PerfectSquare_279 {


    /**
     * 根据343启发，用dp方式
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 3) return n;

        /**
         * dp数组，存放的是，当前位置，完全平方数组成最少的个数（如果本身即为完全平方数，为1）
         */
        int[] mins = new int[n + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        mins[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                mins[i] = Math.min(mins[i], mins[i - j * j] + 1);
            }
        }
        return mins[n];
    }

    /**
     * 判断是不是完全平方数
     *
     * @return
     */
    public boolean checkPerfectSquare(int n) {
        int t = (int) Math.sqrt(n);
        return (t * t) == n;
    }


    public static void main(String[] args) {
        PerfectSquare_279 perfectSquare_279 = new PerfectSquare_279();

        System.out.println(perfectSquare_279.numSquares(5));
    }
}
