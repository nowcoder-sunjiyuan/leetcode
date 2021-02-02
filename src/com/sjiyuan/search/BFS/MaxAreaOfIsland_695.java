package com.sjiyuan.search.BFS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 岛屿的最大面积
 * @author: 孙济远
 * @create: 2021-02-02 13:50
 */
public class MaxAreaOfIsland_695 {

    public static final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    int row = 0;
    int col = 0;
    int[][] tag = null;

    /**
     * 岛屿的最大面积
     * 自己想着写的，感觉还是相率比较低的
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        tag = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(tag[i], 0);
        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(i, j) && grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int x, int y) {
        int result = 1;
        tag[x][y] = 1;
        for (int[] ints : direction) {
            int nx = x + ints[0];
            int ny = y + ints[1];
            if (check(nx, ny) && grid[nx][ny] == 1) {
                int num = dfs(grid, nx, ny);
                result += num;
            }
        }

        return result;
    }

    /**
     * 检查新的目的地是否可以访问
     *
     * @return
     */
    public boolean check(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col && tag[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxAreaOfIsland_695 maxAreaOfIsland_695 = new MaxAreaOfIsland_695();
        int dfs = maxAreaOfIsland_695.maxAreaOfIsland(grid);
    }
}
