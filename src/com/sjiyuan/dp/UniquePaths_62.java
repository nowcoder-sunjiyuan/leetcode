package com.sjiyuan.dp;

/**
 * 不同路径
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        //dp数组，记录到当前节点的步数
        int[][] stepsNum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 在最上面一行，和最左边一行，都应该是单步，为1
                 */
                if (i == 0 || j == 0) {
                    stepsNum[i][j] = 1;
                } else {
                    /**
                     * 其余的用状态转移方程
                     */
                    stepsNum[i][j] = stepsNum[i - 1][j] + stepsNum[i][j - 1];
                }
            }
        }
        return stepsNum[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths_62 uniquePaths_62 = new UniquePaths_62();
        int i = uniquePaths_62.uniquePaths(3, 2);
        System.out.println(i);

    }
}
