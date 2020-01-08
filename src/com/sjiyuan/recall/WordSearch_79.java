package com.sjiyuan.recall;

/**
 * @ClassName WordSearch_79
 * @Description TODO 单词搜索（回溯法，dfs）
 * @Author sjy
 * @Date 2020/1/8 22:45
 * @Version 1.0
 **/
public class WordSearch_79 {
    /**
     * 标记走过的点
     */
    private boolean[][] marked;
    /**
     * board的x，y的长度
     */
    private int m;
    private int n;

    /**
     * 点的四个方向，上下左右
     */
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        marked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        /**
         * 递归到最后，匹配最后一位的字符，此时不需要再向四周走了
         */
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        /**
         * 如果矩阵中某点与单词中index位相同
         */
        if (board[i][j] == word.charAt(index)) {
            marked[i][j] = true;
            /**
             * 四个方向的点都遍历下，符合要求的就往下走
             */
            for (int k = 0; k < 4; k++) {
                int nextX = i + direction[k][0];
                int nextY = j + direction[k][1];
                //符合的情况下就可以向下走
                if (check(nextX, nextY)) {
                    //有成功的情况，就返回true，都没有，才会过这个循环，到false
                    if (dfs(board, word, nextX, nextY, index + 1)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * 判断(x,y)点是否符合要求
     * 1.不能超过边界
     * 2.不能是已经走过的路程
     *
     * @param x
     * @param y
     * @return
     */
    private boolean check(int x, int y) {
        return !(x < 0 || x >= m || y < 0 || y >= n || marked[x][y]);
    }


    public static void main(String args[]) {
        char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        WordSearch_79 w = new WordSearch_79();
        System.out.println(w.exist(board, "CCEA"));

    }
}
