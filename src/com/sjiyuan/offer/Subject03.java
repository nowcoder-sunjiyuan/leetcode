package com.sjiyuan.offer;

/**
 * 数组中重复的数字
 */
public class Subject03 {
    public int findRepeatNumber(int[] nums) {

        int n = nums.length;

        /**
         * 第几位应该放着几的数字，不是的话就交换，找到重复就记录下来，下一个
         * 具体解释，在剑指offer的数组重复部分P40页
         */
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                //相当于找到了一个重复的数据
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //将数字放在其应该放在的位置
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }
}
