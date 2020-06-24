package com.sjiyuan.offer;

/**
 * 机器人的运动范围
 */
public class Subject13 {

    private int m;
    private int n;

    private boolean[][] marked;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;

        marked = new boolean[m][n];
        return movingCountCore(0, 0, k);

    }

    /**
     * 核心算法，移动机器人，递归向四个方向移动
     *
     * @return
     */
    public int movingCountCore(int x, int y, int k) {
        if (check(x, y, k)) {
            marked[x][y] = true;
            return 1 + movingCountCore(x + 1, y, k)
                    + movingCountCore(x - 1, y, k)
                    + movingCountCore(x, y - 1, k)
                    + movingCountCore(x, y + 1, k);
        }
        return 0;

    }

    /**
     * 检查一个点是否符合要求
     *
     * @return
     */
    public boolean check(int x, int y, int k) {
        if ((calculate(x) + calculate(y)) > k || x < 0 || y < 0 || x >= m || y >= n || marked[x][y]) return false;
        return true;
    }

    public int calculate(int data) {
        int result = 0;
        while (data != 0) {
            result = result + data % 10;
            data = data / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Subject13 subject13 = new Subject13();
        int i = subject13.movingCount(3, 1, 0);
        System.out.println(i);
    }
}
