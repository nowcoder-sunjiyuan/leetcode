package com.sjiyuan.dp;

/**
 * @ClassName MaxSubArray_53
 * @Description TODO 最大子序和
 * @Author sjy
 * @Date 2020/2/2 22:09
 * @Version 1.0
 **/
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int maxNum;
        //存储数组中每个节点结尾的子数组的和(dp数组？？)
        int[] result = new int[nums.length];

        result[0] = nums[0];
        maxNum = result[0];

        for (int i = 1; i < result.length; i++) {
            if (result[i - 1] >= 0) {
                /**
                 * 前一位最大和大于等于0的时候，后一位的最大和就是和前一位最大和相加
                 */
                result[i] = result[i - 1] + nums[i];
            } else {
                /**
                 * 前一位最大和是负数的时候，后一位的最大和，就是后一位数字
                 */
                result[i] = nums[i];
            }
            if(result[i] > maxNum) maxNum = result[i];

        }
        return maxNum;
    }
}
