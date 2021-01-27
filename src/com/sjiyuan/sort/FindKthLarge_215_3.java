package com.sjiyuan.sort;

/**
 * @program: LeetCode
 * @description: 找到第k大的数, 用堆排序实现
 * @author: 孙济远
 * @create: 2021-01-27 16:02
 */
public class FindKthLarge_215_3 {
    public int findKthLargest(int[] nums, int k) {
        HeapSort heapSort = new HeapSort();
        /**
         * 若找第K大的，用大顶堆，找到第k个大的
         * 每次遍历找出这一次最大的，找k次，就是第k大的
         */
        int length = nums.length;
        for (int j = 0; j < k; j++) {
            for (int i = length / 2 - 1; i >= 0; i--) {
                heapSort.adjust(nums, i, length);
            }
            heapSort.swap(nums, 0, length - 1);
            length--;
        }
        return nums[length];
    }

}
