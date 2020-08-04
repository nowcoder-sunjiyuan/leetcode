package com.sjiyuan.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * 从小到大排序
 */
public class BubbleSort {
    public int[] bubbleSort(int[] nums) {

        if (nums.length == 0) return nums;
        /**
         * 每次把前面的数字，冒泡到最后
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String args[]) {
        int[] nums = {6, 3, 8, 1, 9, 4, 0};

        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(ints));
    }

}
