package com.sjiyuan.bit;

/**
 * @program: LeetCode
 * @description: 只出现一次的数字
 * @author: 孙济远
 * @create: 2021-01-31 16:07
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
