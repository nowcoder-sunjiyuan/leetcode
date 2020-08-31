package com.sjiyuan.test;

import java.util.Arrays;

public class Main {
    public int[] maxSubArray(int[] nums) {

        //以当前节点结尾的最大子序和的值
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

    public static void main(String args[]) {
        Main main = new Main();
        int[] ints = main.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(Arrays.toString(ints));

    }
}
