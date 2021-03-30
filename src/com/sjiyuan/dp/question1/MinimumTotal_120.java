package com.sjiyuan.dp.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: LeetCode
 * @description: 三角形最小路径和
 * @author: 孙济远
 * @create: 2021-03-31 01:29
 */
public class MinimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        if(triangle.size() == 1) return dp[0][0];
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {

                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if (i - 1 < j) {
                    // 说明上面没数字
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }

                System.out.print(dp[i][j] + " ");
                if (i == triangle.size() - 1) {
                    result = Math.min(dp[i][j], result);
                }
            }
            System.out.println();

        }
        return result;
    }

    public static void main(String[] args) {
        MinimumTotal_120 minimumTotal_120 = new MinimumTotal_120();
        int[][] num = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        List<List<Integer>> t = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            List<Integer> collect = Arrays.stream(num[i]).boxed().collect(Collectors.toList());
            t.add(collect);
        }
        minimumTotal_120.minimumTotal(t);
    }
}
