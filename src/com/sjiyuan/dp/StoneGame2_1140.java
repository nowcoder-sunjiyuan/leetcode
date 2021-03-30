package com.sjiyuan.dp;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-28 21:17
 */
public class StoneGame2_1140 {
    public int stoneGameII(int[] piles) {
        int length = piles.length;
        // dp存的是，当前m = j + 1时，数组i - length-1能取到的最大石子
        int[][] dp = new int[length][length + 1];

        int remain = 0;
        for (int i = length - 1; i >= 0; i--) {
            // 此处可以简化
            remain += piles[i];
            /*int remain = 0;
            for (int t = i; t < length; t++) {
                remain += piles[t];
            }*/
            for (int j = length; j > 0; j--) {

                // 如果最后能取的石子堆数大于最后剩余的堆数，那就直接取了就行
                if (2 * j >= length - i) {
                    dp[i][j] = remain;
                } else {
                    // 如果能取得石子堆数小于剩余的堆数，我们要找一个我们能取得堆数，使得下一个他取得的数量最少
                    int min = Integer.MAX_VALUE;
                    for (int m = 1; m <= 2 * j; m++) {
                        int nextM = Math.max(m, j);
                        if (dp[i + m][nextM] < min) {
                            min = dp[i + m][nextM];
                        }
                    }
                    dp[i][j] = remain - min;
                }
            }
        }
        /*for(int i = 0; i < length; i++){
            for(int j = 1; j <= length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }*/
        return dp[0][1];
    }

    public static void main(String[] args) {
        StoneGame2_1140 stoneGame2_1140 = new StoneGame2_1140();
        stoneGame2_1140.stoneGameII(new int[]{2, 7, 9, 4, 4});
    }
}
