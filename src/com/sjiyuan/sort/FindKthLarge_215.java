package com.sjiyuan.sort;

import java.util.Random;

/**
 * @ClassName FindKthLarge_215
 * @Description TODO 找到第k大的数
 * @Author sjy
 * @Date 2020/2/1 15:12
 * @Version 1.0
 **/
public class FindKthLarge_215 {
    /**
     * 效率：超过99%
     * 用快排的分区算法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int index = partition(nums, start, end);

        while (index != length - k) {
            if (index > length - k) {
                end = index - 1;
            } else if (index < length - k) {
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
        /**
         * 选出随机的，然后和start位置的数据交换
         */
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

    public static void main(String args[]) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        FindKthLarge_215_2 findKthLarge_215 = new FindKthLarge_215_2();
        int kthLargest = findKthLarge_215.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}