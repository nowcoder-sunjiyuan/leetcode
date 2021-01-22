package com.sjiyuan.dp;

/**
 * @program: LeetCode
 * @description: 最长公共子序列
 * @author: 孙济远
 * @create: 2021-01-16 23:34
 */
public class LongestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        System.out.println("二维数组：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                System.out.print(dp[i + 1][j + 1] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence_1143 longestCommonSubsequence_1143 = new LongestCommonSubsequence_1143();
        System.out.println("最长公共子序列：" + longestCommonSubsequence_1143.longestCommonSubsequence("XYXZYXY", "XZYZZYX"));

    }
}
