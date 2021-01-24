package com.sjiyuan.sort;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = nums[begin];

        int i = begin, j = end;

        while (i < j) {
            //从右向左找到小于pivot的数，其应该在pivot的左侧
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            //再从左向右找到大于pivot的数，其应该在pivot的右侧
            while (i < j && nums[i] < pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5, 1, 1, 2, 0, 4, 11, 11, 1};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
