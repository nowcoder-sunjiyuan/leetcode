package com.sjiyuan.math;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 计数质数
 * @author: 孙济远
 * @create: 2021-01-23 15:45
 */
public class CountPrimes_204 {
    /**
     * 算质数，用埃氏筛
     * 如果x为质数，x的倍数都不是质数。但是2的倍数，3的倍数等等已经在2，3的时候都排除了
     * 所以，从x * x开始，递增往上划定为非质数
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] result = new boolean[n + 1];
        //1代表index是质数，0代表index不是质数
        Arrays.fill(result, true);

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (result[i]) {
                ans++;
                /**
                 * 如果x * x > n,没超过范围
                 */
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        result[j] = false;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountPrimes_204 countPrimes_204 = new CountPrimes_204();
        int i = countPrimes_204.countPrimes(10);
        System.out.println(i);
    }
}
