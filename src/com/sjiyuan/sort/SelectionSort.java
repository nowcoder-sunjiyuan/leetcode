package com.sjiyuan.sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        if (nums.length == 0) return nums;

        for (int i = 0; i < nums.length; i++) {
            int minNums = nums[i];
            int minIndex = i;
            //每一轮都选出最小的
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] < minNums) {
                    minNums = nums[j];
                    minIndex = j;
                }
            }
            //交换选择出的最小的和当前的交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {5, 1, 1, 2, 0, 4, 11, 11, 1};
        selectionSort.selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
