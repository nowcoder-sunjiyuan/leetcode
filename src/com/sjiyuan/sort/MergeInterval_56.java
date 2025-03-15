package com.sjiyuan.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JiYuan Sun
 * @date 2025/03/15
 */
class MergeInterval_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result.toArray(new int[][]{});
        }
        // quickSort(intervals, 0, intervals.length - 1);
        // 改造一下不用quickSort
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = result.get(result.size() - 1);
            int[] now = intervals[i];
            if (tmp[1] < now[0]) {
                result.add(now);
            } else {
                if (tmp[1] < now[1]) {
                    tmp[1] = now[1];
                }
            }
        }
        return result.toArray(new int[][]{});
    }


    // 排序
    public void quickSort(int[][] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(data, low, high);
        quickSort(data, low, partition - 1);
        quickSort(data, partition + 1, high);
    }

    public int partition(int[][] data, int low, int high) {
        int pivot = data[high][0];
        int min = low;

        for (int j = low; j < high; j++) {
            if (data[j][0] > pivot) {
                continue;
            }
            swap(data, min, j);
            min++;
        }
        swap(data, min, high);
        return min;
    }

    public void swap(int[][] data, int i, int j) {
        if (i == j) {
            return;
        }
        int[] tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        MergeInterval_56 s = new MergeInterval_56();

        s.merge(intervals);
    }
}