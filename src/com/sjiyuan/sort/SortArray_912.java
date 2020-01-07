package com.sjiyuan.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SortArray_912
 * @Description TODO 排序数组
 * @Author sjy
 * @Date 2020/1/7 23:16
 * @Version 1.0
 **/
public class SortArray_912 {
    /**
     * 快排
     * @param nums
     * @return
     */
    public List<Integer> QuickSort(int[] nums) {
        partition(nums, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            result.add(i);
        }
        return result;
    }

    public void partition(int nums[], int low, int high) {
        int pivot = nums[low];

        /**
         * flag为0表示是low向高处走，flag为1表示high向低处走
         */
        int flag = 1;
        int i, j;
        for (i = low, j = high; i < j; ) {
            if (flag == 1) {
                if (nums[j] < pivot) {
                    nums[i] = nums[j];
                    i++;
                    flag = 0;
                } else {
                    j--;
                }
            } else {
                if (nums[i] >= pivot) {
                    nums[j] = nums[i];
                    j--;
                    flag = 1;
                } else {
                    i++;
                }
            }
        }
        nums[i] = pivot;
        if (low < i - 1) partition(nums, low, i - 1);
        if (high > i + 1) partition(nums, i + 1, high);
    }


    public static void main(String args[]) {
        int[] nums = {5, 1, 1, 2, 0, 4, 11 ,11, 1};
        SortArray_912 sort = new SortArray_912();
        System.out.println("快排结果：" + sort.QuickSort(nums));
    }
}
