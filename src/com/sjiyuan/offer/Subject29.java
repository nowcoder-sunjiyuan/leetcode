package com.sjiyuan.offer;

/**
 * 顺时针打印矩阵
 */
public class Subject29 {
    /**
     * 四个方向，顺时针，右，下，左，上
     */
    private final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] flag;
    int rowLength;
    int columnLength;

    /**
     * 跟54方法不同，
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {

        rowLength = matrix.length;
        if (rowLength == 0) return new int[0];
        columnLength = matrix[0].length;
        if (columnLength == 0) return new int[0];

        int[] result = new int[rowLength * columnLength];
        flag = new boolean[rowLength][columnLength];

        int locationX = 0;
        int locationY = 0;
        //方向的坐标
        int coordinate = 0;
        for (int i = 0; i < rowLength * columnLength; i++) {
            result[i] = matrix[locationX][locationY];
            flag[locationX][locationY] = true;
            /**
             * 判断修改后的坐标是否符合要求
             */
            if (!checkLocation(locationX + direction[coordinate][0],
                    locationY + direction[coordinate][1])) {
                coordinate = (coordinate + 1) % 4;
            }

            locationX += direction[coordinate][0];
            locationY += direction[coordinate][1];
        }
        return result;
    }

    /**
     * 检查坐标是否符合要求
     *
     * @return
     */
    public boolean checkLocation(int x, int y) {
        return x >= 0 && x < rowLength && y >= 0 && y < columnLength && !flag[x][y];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Subject29 subject29 = new Subject29();
        int[] ints = subject29.spiralOrder(matrix);
        System.out.println("hahah ");

    }

}
