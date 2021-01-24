package com.sjiyuan.array;

/**
 * @program: LeetCode
 * @description: 移动零 easy
 * @author: 孙济远
 * @create: 2021-01-24 11:59
 */
public class MoveZeroes_283 {
    //双指针实现
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; i++, j++) {
            while (j < nums.length && nums[j] == 0) j++;
            if(j == nums.length) break;
            nums[i] = nums[j];
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
