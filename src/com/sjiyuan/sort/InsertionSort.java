package com.sjiyuan.sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] insertionSort(int nums[]) {
        if (nums.length == 0) return nums;
        int i = 0;
        while (i < nums.length - 1) {
            //现在插入的元素
            int current = nums[i + 1];
            int j = i;
            for (;j >= 0; j--) {
                if (nums[j] > current) {
                    nums[j + 1] = nums[j];
                } else {
                    nums[j + 1] = current;
                    break;
                }
            }
            if(j == -1) nums[0] = current;
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] nums = {5, 1, 1, 2, 0, 4, 11, 11, 1};
        insertionSort.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
