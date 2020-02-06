package com.sjiyuan.array;

/**
 * @ClassName RemoveElement_27
 * @Description TODO 移除元素
 * @Author sjy
 * @Date 2020/2/6 15:35
 * @Version 1.0
 **/
public class RemoveElement_27 {
    /**
     * 删除固定值元素，空间O(1)，双指针法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int point1 = 0;
        int point2 = 0;


        while (point1 < nums.length) {
            if (nums[point1] == val) {
                point1++;
            } else {
                nums[point2] = nums[point1];
                point2++;
            }
        }

        return point2 + 1;

    }
}
