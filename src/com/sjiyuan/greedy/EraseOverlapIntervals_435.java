package com.sjiyuan.greedy;

/**
 * @program: LeetCode
 * @description: 无重叠区间
 * @author: 孙济远
 * @create: 2021-01-27 17:40
 */
public class EraseOverlapIntervals_435 {
    /**
     * 贪心算法实现
     * 按照区间末尾排序
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //先排序，按照末尾区间排序
        int row = intervals.length;
        if (row == 0) return 0;
        partition(intervals, 0, row - 1);

        int result = 0;
        //然后贪心算法
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last) {
                result++;
            } else {
                last = intervals[i][1];
            }
        }
        return result;
    }


    public void partition(int[][] nums, int start, int end) {

        if (start >= end) return;

        int pivot = nums[start][1];
        int pivotX = nums[start][0];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j][1] >= pivot) {
                j--;
            }
            nums[i][0] = nums[j][0];
            nums[i][1] = nums[j][1];
            while (i < j && nums[i][1] < pivot) {
                i++;
            }
            nums[j][0] = nums[i][0];
            nums[j][1] = nums[i][1];
        }
        nums[i][0] = pivotX;
        nums[i][1] = pivot;
        partition(nums, start, i - 1);
        partition(nums, i + 1, end);

    }


    public static void main(String[] args) {
        EraseOverlapIntervals_435 eraseOverlapIntervals_435 = new EraseOverlapIntervals_435();
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals_435.eraseOverlapIntervals(intervals));
    }
}
