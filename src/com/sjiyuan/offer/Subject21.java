package com.sjiyuan.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Subject21 {
    public int[] exchange(int[] nums) {
        if(nums.length == 0) return nums;
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            //判断是奇数
            if((nums[i] & 1) == 1){
                i++;
                continue;
            }
            if((nums[j] & 1) == 0){
                j--;
                continue;
            }

            //交换nums[i]与nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
