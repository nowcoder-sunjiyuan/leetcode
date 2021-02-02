package com.sjiyuan.greedy;

/**
 * @program: LeetCode
 * @description: 无重叠区间
 * @author: 孙济远
 * @create: 2021-01-27 17:40
 */
public class EraseOverlapIntervals_435 {
    /**
     * 理解：
     * 首先按照末尾排序，在某一种最优的选择方法中，第一个区间A肯定是最左侧区间，如果A不是，B是（B也一定可以被A取代）
     * 当确定了首个区间之后，所有与首个区间不重合的区间就组成了一个规模更小的子问题。
     * 由于我们已经在初始时将所有区间按照右端点排好序了，因此对于这个子问题，我们无需再次进行排序，只要找出其中与首个区间不重合并且右端点最小的区间即可。
     * 用相同的方法，我们可以依次确定后续的所有区间。
     *
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
