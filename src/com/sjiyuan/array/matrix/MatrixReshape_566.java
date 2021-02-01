package com.sjiyuan.array.matrix;

/**
 * @program: LeetCode
 * @description: 重塑矩阵
 * @author: 孙济远
 * @create: 2021-01-30 17:18
 */
public class MatrixReshape_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int row = nums.length;
        int col = nums[0].length;

        if (row * col != r * c) return nums;
        int[][] result = new int[r][c];
        int a = 0, b = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[a][b] = nums[i][j];
                if (b + 1 == c) {
                    a++;
                    b = 0;
                } else b++;
            }
        }
        return result;
    }
}
