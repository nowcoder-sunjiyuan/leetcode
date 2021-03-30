package com.sjiyuan.dp.question1;

/**
 * @program: LeetCode
 * @description: 最长公共子序列
 * @author: 孙济远
 * @create: 2021-03-31 02:15
 */
public class LongestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 这个dp[i][j]存的是，text1的i位之前和text2的j位之前最长公共子序列
        // 分情况，如果，第i位与第j位相等，d[i][j] = d[i - 1][j -1]
        // 如果不等，取d[i][j - 1]与d[i - 1][j]中的最大值
        int[][] dp = new int[text1.length()][text2.length()];
        if(text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1;
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                int left = j - 1;
                int up = i - 1;
                if(text1.charAt(i) == text2.charAt(j)){
                    if(left < 0 || up < 0) dp[i][j] = 1;
                    else dp[i][j] = dp[up][left] + 1;
                }else{
                    int leftNum = 0;
                    int upNum = 0;
                    if(left >= 0) leftNum = dp[i][j - 1];
                    if(up >= 0) upNum = dp[i - 1][j];
                    dp[i][j] = Math.max(leftNum, upNum);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() -1];
    }
}
