package com.sjiyuan.heap;

import java.util.ArrayList;

/**
 * @ClassName MaxHeap
 * @Description TODO 实现一个大顶堆
 * @Author sjy
 * @Date 2020/2/2 11:14
 * @Version 1.0
 **/
public class MaxHeap<E extends Comparable<E>> {
    //用数组放置大顶堆
    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("node is root");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(size() - 1);
    }

    /**
     * 向上浮，把大的数字向上浮
     *
     * @param k
     */
    private void siftUp(int k) {
        /**
         * 在integer里面，x < y 返回 -1，等于返回 0，大于返回 1
         */
        while (k > 0 && get(k).compareTo(get(parent(k))) > 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int a, int b) {
        E temp = data.get(a);

        data.set(a, data.get(b));
        data.set(b, temp);
    }

    private E get(int index) {
        return this.data.get(index);
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public E findMax() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        return data.get(0);
    }

    /**
     * 取到最大值，并从新构成大顶堆
     *
     * @return
     */
    public E getMax() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }

        swap(0, size() - 1);

        E result = data.get(size() - 1);
        data.remove(size() - 1);

        int k = 0;

        //如果左孩子大于size，说明到叶子节点了
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            /**
             * 右节点存在，并且右节点更大，将j改成右节点
             */
            if (j + 1 < size() && get(j).compareTo(get(j + 1)) < 0) j = j + 1;

            /**
             * 如果k的值，大于孩子节点的值，停止下沉（只跟最大的孩子节点比）
             */
            if (get(k).compareTo(get(j)) >= 0) break;

            swap(k, j);
            k = j;
        }

        return result;
    }
}