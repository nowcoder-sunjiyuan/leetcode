package com.sjiyuan.dichotomy;

/**
 * @program: LeetCode
 * @description: 有序数组中的单一元素
 * @author: 孙济远
 * @create: 2021-02-01 17:00
 */
public class SingleNonDuplicate_540 {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if(start == end) return nums[start];

        int mid = (start + end) / 2;
        int leftEnd;
        int rightStart;
        while (true) {
            if (nums[mid - 1] == nums[mid]) {
                leftEnd = mid - 2;
                rightStart = mid + 1;
            } else if (nums[mid + 1] == nums[mid]) {
                leftEnd = mid - 1;
                rightStart = mid + 2;
            } else {
                return nums[mid];
            }

            if(leftEnd == start) return nums[start];
            if(rightStart == end) return nums[end];

            /**
             * 看左右哪个是奇数
             */
            if ((leftEnd - start) % 2 == 0) {
                //左侧为奇数
                end = leftEnd;
            } else {
                //右侧为奇数
                start = rightStart;
            }
            mid = (start + end) / 2;

        }
    }
}
