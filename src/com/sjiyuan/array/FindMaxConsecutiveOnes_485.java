package com.sjiyuan.array;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-02-04 10:40
 */
public class FindMaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result = Math.max(result, i - pre - 1);
                pre = i;
            }
        }
        result = Math.max(result, nums.length - pre - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
        FindMaxConsecutiveOnes_485 f = new FindMaxConsecutiveOnes_485();
        System.out.println(f.findMaxConsecutiveOnes(nums));
    }
}
