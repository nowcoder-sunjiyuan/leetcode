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

    /**
     * 返回最大子序和数组的实现
     * @param nums
     * @return
     */
    public int[] maxSubArray_ReturnArray(int[] nums) {

        //以当前节点结尾的最大子序和的值（dp数组）
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];

        //记录以当前节点结尾最大子序和的起始节点
        int[] begin = new int[nums.length];

        //最大值结尾的数组下标
        int maxNumBeginIndex = 0;
        int maxNumEndIndex = 0;
        //最大值,初始化为maxArray[0]
        int max = maxArray[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxArray[i - 1] + nums[i] > nums[i]) {
                maxArray[i] = maxArray[i - 1] + nums[i];
                begin[i] = begin[i - 1];

            } else {
                maxArray[i] = nums[i];
                begin[i] = i;
            }

            if (maxArray[i] > max) {
                maxNumBeginIndex = begin[i];
                maxNumEndIndex = i;
                max = maxArray[i];
            }
        }
        int[] result = new int[maxNumEndIndex - maxNumBeginIndex + 1];
        //数组的赋值
        System.arraycopy(nums, maxNumBeginIndex, result, 0,
                maxNumEndIndex - maxNumBeginIndex + 1);
        return result;
    }


}
