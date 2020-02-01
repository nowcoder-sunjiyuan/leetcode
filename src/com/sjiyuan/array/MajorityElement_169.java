package com.sjiyuan.array;

import java.util.Random;

/**
 * @ClassName MajorityElement_169
 * @Description TODO 多数元素
 * @Author sjy
 * @Date 2020/1/31 19:10
 * @Version 1.0
 **/
public class MajorityElement_169 {
    /**
     * 用partition（快排的分区）的方法
     * 如果是多数的元素，则排好序的数组，中位一定是多数元素数据
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int length = nums.length;
        int start = 0;
        int end = nums.length - 1;

        int index = partition(nums, start, end);
        while (index != length / 2) {
            if (index > length / 2) {
                end = index - 1;
            } else if (index < length / 2) {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    /**
     * 快排的分区
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] nums, int start, int end) {

        if (start == end) return start;
        Random random_num = new Random();
        int pivot_index = start + random_num.nextInt(end - start);
        swap(pivot_index, start, nums);

        int pivot = nums[start];
        int low, high;

        for (low = start, high = end; low < high; ) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        //pivot放在最终的位置
        nums[low] = pivot;

        //返回位置
        return low;

    }

    public void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 效率：超过87%
     * 用计数的方式，最大数，和次数
     * 因为最大数比其他所有的数字总和都多，先假定一个数是最多的，每出现一次就加一，没出现一次减一，为0时就换成新的数
     * 最后轮到的数，一定是数量最多的
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int max = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                max = nums[i];
                count++;
            }
            else if(max == nums[i]) count++;
            else if(max != nums[i]) count--;
        }

        return max;
    }


    public static void main(String arg[]) {
        int[] nums = {47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83, 33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47, 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47, 47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47, 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47, 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36, 47, 41, 19, 80, 47, 47, 27};
        MajorityElement_169 majorityElement_169 = new MajorityElement_169();
        int i = majorityElement_169.majorityElement2(nums);
        System.out.println("答案：" + i);
    }
}
