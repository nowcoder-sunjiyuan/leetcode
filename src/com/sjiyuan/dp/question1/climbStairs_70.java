package com.sjiyuan.dp.question1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 爬楼梯
 */
public class climbStairs_70 {
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

}
