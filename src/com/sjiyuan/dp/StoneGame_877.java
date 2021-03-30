package com.sjiyuan.dp;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-28 18:13
 */
public class StoneGame_877 {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        // dp数组存当前用户如果选完，比另外一个用户多的石子数量
        // 如果还剩奇数堆，则一定是第二个人选，此时，选完后，第二个人比第一个人多piles[i]个石子
        // 如果还是偶数堆，则一定是第一个人先选
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 如果只剩下一个，说明是第二个比第一个人多的石子数量
                if (i == j) dp[i][j] = piles[i];
                if (i < j) dp[i][j] = 0;
            }
        }
        // j代表的是差值
        for (int j = 1; j < length; j++) {
            for (int i = 0; i + j < length; i++) {
                // 算dp[i][i+j]
                int temp = piles[i] - dp[i + 1][i + j];
                int temp2 = piles[i + j] - dp[i][i + j - 1];

                dp[i][i + j] = Math.max(temp, temp2);
            }

        }

        /*for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        StoneGame_877 stoneGame_877 = new StoneGame_877();
        stoneGame_877.stoneGame(new int[]{3, 2, 10, 4});
    }
}
