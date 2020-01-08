package com.sjiyuan.array;

/**
 * @ClassName FindRotationSortArray_153
 * @Description TODO 查找旋转排序数组中的最小值(二分查找)
 * @Author sjy
 * @Date 2020/1/8 16:41
 * @Version 1.0
 **/
public class FindRotationSortArray_153 {
    /**
     * 二分查找解决（log(N)）
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        //如果旋转移动为0
        if (nums[low] < nums[high]) return nums[low];
        while (low + 1 != high) {
            //0 1 2 3 4 5,middle = 2
            //0 1 2 3 4,middle = 2
            int middle = (low + high) / 2;
            /**
             * 如果出现前后中的值一样，只能顺序遍历
             * 1 1 1 1 1
             * 1 2 1 0 0
             */
            if (nums[low] == nums[high] && nums[low] == nums[middle]) {
                for (int i = low; i < high - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return nums[i + 1];
                    }
                }
                return nums[low];
            }
            /**
             * 这里nums[low]必大于等于nums[high]，当等于成立时，下面的情况不会出现等于
             */
            if (nums[middle] >= nums[low]) {
                low = middle;
            } else if (nums[middle] <= nums[high]) {
                high = middle;
            }
        }
        return nums[high];
    }

    public static void main(String args[]) {
        FindRotationSortArray_153 f = new FindRotationSortArray_153();
        //int[] num = {1, 1, 0, 1, 1, 1, 1};
        int[] num = {4, 5, 6, 7};
        System.out.println("答案：" + f.findMin(num));
    }
}
