package com.sjiyuan.search.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 二进制矩阵中的最短路径
 * @author: 孙济远
 * @create: 2021-01-23 10:06
 */
public class ShortestPathBinaryMatrix_1091 {

    /**
     * 8个方向
     */
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    /**
     * BFS解决
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {

        //定义队列，队列里放数组，里面是x，y
        Queue<int[]> queue = new LinkedList<>();

        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;

        //定义备忘录
        /*int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(grid[i], 0, temp[i], 0, col);
        }*/

        //判断边界条件
        if (grid[0][0] == 1 || grid[row - 1][col - 1] != 0) return -1;

        //初始加入队列，更新备忘录
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            //直接在grid上记录，路径的长度，意思是当前位置距离grid[0][0]的距离
            int distance = grid[xy[0]][xy[1]];
            for (int[] direction : directions) {
                // 新x，新y
                int nx = xy[0] + direction[0];
                int ny = xy[1] + direction[1];

                if (judge(grid, nx, ny)) {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = distance + 1;
                }
            }
        }
        if (grid[row - 1][col - 1] != 0) return grid[row - 1][col - 1];
        return -1;
    }

    /**
     * 判断新的坐标是否符合情况，需要没走过，不能越过界限
     *
     * @param x
     * @param y
     * @return
     */
    private boolean judge(int[][] grid, int x, int y) {

        int row = grid.length;
        int col = grid[0].length;

        return x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0;
    }

    public static void main(String[] args) {
        int test[][] = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        ShortestPathBinaryMatrix_1091 shortestPathBinaryMatrix_1091 = new ShortestPathBinaryMatrix_1091();
        int i = shortestPathBinaryMatrix_1091.shortestPathBinaryMatrix(test);
        System.out.println(i);
    }
}
