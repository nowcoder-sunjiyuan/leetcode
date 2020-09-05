package com.sjiyuan.sort;

public class FindKthLarge_215_2 {
    public int findKthLargest(int[] nums, int k) {
        int index = partition(0, nums.length - 1, nums);

        int start = 0;
        int end = nums.length - 1;
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(start, end, nums);
        }

        return nums[index];

    }

    //快排的分区算法，返回最后pivot的位置
    public int partition(int start, int end, int[] nums) {
        //这里pivot的选举如果是随机的就更好了
        int pivot = nums[start];

        int left = start;
        int right = end;

        while (left < right) {
            /**
             * 先走右边，再走左边
             * 从大到小排序
             * 大的放左边，小的放右边
             */
            while (left < right && nums[right] < pivot) right--;
            nums[left] = nums[right];

            while (left < right && nums[left] >= pivot) left++;
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;
    }
}
