package com.sjiyuan.sort;

import java.util.Arrays;

/**
 * 没有实现
 * 堆排序得实现从小到大
 * （自己写的不好，没写出来，很乱）
 */
public class HeapSort {

    /**
     * 调整某个节点为大顶堆的过程
     *
     * @param array
     * @param current 当前结点的下标
     * @param length
     */
    public void adjust(int[] array, int current, int length) {

        for (int child = 2 * current + 1; child < length; child = 2 * current + 1) {
            //找出最大的孩子
            if (child + 1 < length && array[child + 1] > array[child]) {
                child++;
            }

            if (array[child] > array[current]) {
                swap(array, child, current);
                //将当前节点
                current = child;
            } else break;
        }
    }


    /**
     * 大顶堆排序
     *
     * @param array
     */
    public void heapSort(int[] array) {

        //length代表当前数组的长度
        for (int length = array.length; length > 1; length--) {
            /**
             * 先把数组调整成大顶堆
             */
            for (int i = array.length / 2 - 1; i >= 0; i--) {
                adjust(array, i, length);
            }

            /**
             * 再交换大顶堆和末尾的数字，此时最大的在末尾
             */
            swap(array, 0, length - 1);
        }
    }

    /**
     * 交换数组中i位和j位的值
     *
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 8, 5, 6, 7, 2, 0, 4};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
