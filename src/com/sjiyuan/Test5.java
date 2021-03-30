package com.sjiyuan;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-29 20:12
 */
public class Test5 {
    public static boolean searchMatrix(int[][] nums, int x) {
        // Todo your code goes here...
        if (nums == null || nums[0] == null) return false;

        int row = nums.length;
        int col = nums[0].length;
        if (nums[row - 1][col - 1] < x || nums[0][0] > x) return false;

        int rowNow = 0;
        for (int i = 0; i < row; i++) {
            if (nums[i][0] > x) {
                rowNow = i - 1;
                break;
            }
            else if (nums[i][0] == x) {
                return true;
            } else if (i == row - 1) {
                // 已经是最后一行了
                rowNow = row - 1;
            }
        }
        //1 2 3 4
        for (int start = 0, end = col - 1; start <= end; ) {
            int middle = (start + end) / 2;
            if (nums[rowNow][middle] == x) return true;
            else if (nums[rowNow][middle] > x) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 5}};
        boolean b = searchMatrix(test, 9);
        System.out.println(b);

    }
}
