package com.sjiyuan.dp.question2;

/**
 * 最小路径和
 */
public class minPathSum_64 {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        //dp数组
        int[][] minPath = new int[m][n];
        minPath[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            minPath[0][i] = minPath[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (minPath[i - 1][j] < minPath[i][j - 1]) {
                    minPath[i][j] = minPath[i - 1][j] + grid[i][j];
                } else {
                    minPath[i][j] = minPath[i][j - 1] + grid[i][j];
                }
            }
        }
        return minPath[m - 1][n - 1];
    }
}
