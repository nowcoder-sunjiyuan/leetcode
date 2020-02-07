package com.sjiyuan.array;

/**
 * @ClassName MissingNumber_268
 * @Description TODO 缺失数字
 * @Author sjy
 * @Date 2020/2/7 21:33
 * @Version 1.0
 **/
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {

        int length = nums.length;

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        return (length * (length + 1)) / 2 - sum;
    }

    public static void main(String args[]) {
        int[] nums = {3, 0, 1};
        MissingNumber_268 missingNumber_268 = new MissingNumber_268();
        System.out.println("答案：" + missingNumber_268.missingNumber(nums));
    }
}
